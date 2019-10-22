package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeStockLogMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeStockLog;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
@Component
public class MqProvider {
    @Value("${mq.address}")
    private String address;
    @Value("${mq.producerGroup}")
    private String producerGroup;
    @Value("${mq.topic}")
    private String topic;
    @Value("${mq.transactionducergroup}")
    private String transactiongroup;

    private DefaultMQProducer producer;

    //    事务消息的生产者
    private TransactionMQProducer transactionMQProducer;

    @Autowired
    SeckillService seckillService;

    @Autowired
    MtimeStockLogMapper mtimeStockLogMapper;

    @PostConstruct
    public void init() throws MQClientException {
//      public static void main(String[] args) throws MQClientException {
//        实例化消息生成者
        producer = new DefaultMQProducer(producerGroup);
//        设置消息提供者的IP地址
        producer.setNamesrvAddr(address);
        producer.setInstanceName(RunTimeUtil.getRocketMqUniqeInstanceName());
//        producer.setNamesrvAddr("localhost:9876");
//        启动消息生成者
        producer.start();
        System.out.println("mq消息生成者启动成功！  ");

//        事务消息生成者
        transactionMQProducer = new TransactionMQProducer(transactiongroup);
        transactionMQProducer.setNamesrvAddr(address);

        transactionMQProducer.start();

        System.out.println("事务消息生成者启动成功！  ");
//        事务消息监听者
        transactionMQProducer.setTransactionListener(new TransactionListener() {
//            此方法执行本地事务，引入service执行本地事务
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object arg) {
                if (arg == null) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                HashMap<String, Object> argMap = (HashMap<String, Object>) arg;
                Integer promoId = (Integer) argMap.get("promoId");
                Integer amount = (Integer) argMap.get("amount");
                Integer userId = (Integer) argMap.get("userId");
                String stockLogId = (String) argMap.get("stockLogId");
                RespPromoBaseVo order = null;
                try {
                    order = seckillService.createOrder(promoId, amount, userId,stockLogId);
                } catch (MQClientException e) {
                    e.printStackTrace();
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
//                根据Vo返回的数据是否为空判断操作是否成功
//                Object data = order.getData();
                if (order == null) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                return LocalTransactionState.COMMIT_MESSAGE;
            }

//            如若一定时间内没有回音，通过此方法进行回查
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                byte[] body = messageExt.getBody();
                String bodyString = new String(body);
                HashMap<String,Object> hashMap = JSON.parseObject(bodyString, HashMap.class);
                String stockLogId = (String) hashMap.get("stockLogId");
                MtimeStockLog stockLog = mtimeStockLogMapper.selectById(stockLogId);
                Integer status = stockLog.getStatus();
                if (2 == status) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (3 == status) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else{
                    return LocalTransactionState.UNKNOW;
                }
            }
        });
    }


    public void sendMsg(Integer promoId,Integer amount) throws MQClientException {
//      生成消息
        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("amount", args[1]);
//        hashMap.put("promoId", args[0]);
        hashMap.put("amount", amount);
        hashMap.put("promoId", promoId);
//      将消息装换成json字符串
        String jsonString = JSON.toJSONString(hashMap);
//      json字符串封装进特有的Message对象中
        Message message = new Message(topic, "p", jsonString.getBytes());
//      发送消息结果
        SendResult sendResult = null;

        try {
            sendResult = producer.send(message);
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(sendResult));
    }

    /*
     * 事务创建订单
     * */
    public Boolean transactionCreateOrder(Integer promoId, Integer amount, Integer userId, String stockLogId) {
//        Massage参数的生成
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("promoId", promoId);
        hashMap.put("amount", amount);
        hashMap.put("userId", userId);
        hashMap.put("stockLogId", stockLogId);
        String jsonString = JSON.toJSONString(hashMap);
//        封装进入Message中
        Message message = new Message(topic, jsonString.getBytes());

//        进行arg参数的生成
        HashMap<String, Object> argHashMap = new HashMap<>();
        argHashMap.put("promoId", promoId);
        argHashMap.put("amount", amount);
        argHashMap.put("userId", userId);
        argHashMap.put("stockLogId", stockLogId);

        TransactionSendResult transactionSendResult = null;
        try {
//            发送消息到消息提供者的监听器中
            transactionSendResult = transactionMQProducer.sendMessageInTransaction(message, argHashMap);
        } catch (MQClientException e) {
            e.printStackTrace();
//            如若有异常返回false
            return false;
        }
        if (transactionSendResult == null) {
            return false;
        }
//        通过消息结果集，判断本地事务是否执行完成，完成返回true
        LocalTransactionState localTransactionState = transactionSendResult.getLocalTransactionState();
        if (LocalTransactionState.COMMIT_MESSAGE.equals(localTransactionState)) {
            return true;
        }
        return false;
    }
}
