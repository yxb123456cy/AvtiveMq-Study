package org.qy.activemq.memcacheddemo.config;

import lombok.RequiredArgsConstructor;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.qy.activemq.memcacheddemo.properties.MemCachedProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * MemCached配置：
 */
@Configuration
public class MemCachedConfig {

    @Autowired
    private MemCachedProperties memCachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(memCachedProperties.getIp() + ":" + memCachedProperties.getPort());
        memcachedClientBuilder.setConnectionPoolSize(memCachedProperties.getPoolSize());
        memcachedClientBuilder.setConnectTimeout(memCachedProperties.getOpTimeout());
        return memcachedClientBuilder.build();
    }

}
