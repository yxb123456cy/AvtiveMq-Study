package org.qy.activemq.memcacheddemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MemCached 连接数据配置类;
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.memcached")
public class MemCachedProperties {
    private String ip;//Memcached 服务IP;
    private String port;//Memcached 端口
    private int poolSize; //连接池大小;
    private long opTimeout; //连接超时时间
}
