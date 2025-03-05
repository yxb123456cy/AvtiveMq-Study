package org.qy.activemq.provider;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.concurrent.CompletableFuture;

/**
 * 开启JMS;
 */
@EnableJms
@SpringBootApplication
public class ProviderApplication implements ApplicationRunner {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Resource
    private Topic CCtVTopic;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //正确创建队列并发送消息的方法;

        CompletableFuture.runAsync(()->{
            jmsMessagingTemplate.convertAndSend(queue, "我在学SpringBoot");
        }).join();
        CompletableFuture.runAsync(()->{
            jmsMessagingTemplate.convertAndSend(CCtVTopic, "这是cctv的央视一号");
        }).join();

        for (int i = 0; i < 2; i++) {
            jmsMessagingTemplate.convertAndSend("elk.queue", "springBoot");
        }

    }
}
