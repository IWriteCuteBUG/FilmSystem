package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoStockMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
@Component
public class MqConsumer {
//    方案1
    @Autowired
    private MtimePromoStockMapper mtimePromoStockMapper;
    @Autowired
    private static MqConsumer mqConsumer;
    @PostConstruct
    public void init(){
        mqConsumer = this;
        mqConsumer.mtimePromoStockMapper = this.mtimePromoStockMapper;
    }

//    方案2
   /* private static MtimePromoStockMapper mtimePromoStockMapper;
    @Autowired
    public void setMtimePromoStockMapper(MtimePromoStockMapper MtimePromoStockMapper) {
        MqConsumer.mtimePromoStockMapper = MtimePromoStockMapper;
    }*/

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer2");

        consumer.setNamesrvAddr("localhost:9876");

        consumer.subscribe("topicA","*");



        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //                永远只从消息队列的顶部拿数据
                MessageExt messageExt = msgs.get(0);
//                转换为字符串数组
                byte[] body = messageExt.getBody();
//                转换为字符串
                String receiveString = new String(body);
//               将字符串转换为HashMap
                HashMap<String,Object> hashMap = JSON.parseObject(receiveString, HashMap.class);
//               取出活动Id,与要扣减的仓库数量
                Integer promoId = (Integer) hashMap.get("promoId");
                Integer amount = (Integer) hashMap.get("amount");
                System.out.println("promoId = " + promoId);
                System.out.println("amount = " + amount);
//                 方案1
                mqConsumer.mtimePromoStockMapper.updateByPromoId(promoId, amount);
//                方案2
//                int update = mtimePromoStockMapper.updateByPromoId(promoId, amount);
//                返回一枚举类型
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
