package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.HashMap;

public class MqProvider {
    public static void sendMsg(Integer promoId,Integer amount) throws MQClientException {
//      public static void main(String[] args) throws MQClientException {
//        实例化消息生成者
        DefaultMQProducer producer = new DefaultMQProducer("producerA");
//        设置消息提供者的IP地址
//        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName(RunTimeUtil.getRocketMqUniqeInstanceName());
        producer.setNamesrvAddr("localhost:9876");
//        启动消息生成者
        producer.start();
        System.out.println("mq消息生成者启动成功！  ");
//      生成消息
        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("amount", args[1]);
//        hashMap.put("promoId", args[0]);
        hashMap.put("amount", amount);
        hashMap.put("promoId", promoId);
//      将消息装换成json字符串
        String jsonString = JSON.toJSONString(hashMap);
//      json字符串封装进特有的Message对象中
        Message message = new Message("topicA", "p", jsonString.getBytes());
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
}
