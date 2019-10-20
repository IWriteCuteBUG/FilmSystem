package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConsumerConfig {
    @Bean(initMethod = "init")
    public MqConsumer mqConsumer() {
        MqConsumer mqConsumer = new MqConsumer();
        return mqConsumer;
    }
}
