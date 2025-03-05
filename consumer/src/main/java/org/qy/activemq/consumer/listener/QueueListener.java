package org.qy.activemq.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueListener {

    /**
     * destination 可以代表Queue通道和Topic通道
     * @param msg
     */
    @JmsListener(destination = "elk.queue")
    public void consumer(String msg) {
        log.info("获取来自elk.queue的消息 message:{}", msg);
    }

    @JmsListener(destination = "springboot.queue")
    public void consumer2(String msg) {
        log.info("获取来自springboot.queue的消息 message:{}", msg);
    }

    @JmsListener(destination = "cctv.topic")
    public void consumer3(String msg) {
        log.info("订阅主题 获取到message:{}", msg);
    }
}
