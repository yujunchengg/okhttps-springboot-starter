package io.github.yujunchengg.okhttps.starter.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
@Component
@ConfigurationProperties(prefix = "starter.okhttps")
@Data
public class OkHttpsProperties {
    private Duration connectTimeout=Duration.ofSeconds(10);
    private Duration readTimeout=Duration.ofMillis(500);
    private Duration writeTimeout=Duration.ofMillis(500);
    private Duration keepAliveDuration=Duration.ofSeconds(5000);
    private Integer maxIdle=100;
    private String baseUrl;
    private Pool pool=new Pool();
    @Data
    public static class Pool{
        private int maxIdleConnections=5;
        private long keepAliveDuration=5L;
        private TimeUnit timeUnit=TimeUnit.MINUTES;
    }
}
