package org.qy.activemq.provider.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {
    @Bean
    public Queue SpringBootQueue() {
        return new ActiveMQQueue("springboot.queue");
    }

    //主题(发布\订阅模式)通道
    @Bean
    Topic CCtVTopic() {
        return new ActiveMQTopic("cctv.topic");
    }

}
