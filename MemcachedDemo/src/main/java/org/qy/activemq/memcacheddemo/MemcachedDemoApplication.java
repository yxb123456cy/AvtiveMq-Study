package org.qy.activemq.memcacheddemo;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MemcachedDemoApplication implements ApplicationRunner {

    @Autowired
    private  MemcachedClient memcachedClient;



    public static void main(String[] args) {
        SpringApplication.run(MemcachedDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memcachedClient.set("elk", 20, "mq");
        Object object = memcachedClient.get("elk");
        String mq = (String) object;
        log.info("data:{}", mq);
    }
}
