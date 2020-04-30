package io.github.yujunchengg.okhttps.starter.config;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.HttpClient;
import com.google.common.base.Strings;
import io.github.yujunchengg.okhttps.starter.prop.OkHttpsProperties;
import io.github.yujunchengg.okhttps.starter.template.async.AsyncGetTemplate;
import io.github.yujunchengg.okhttps.starter.template.sync.DeleteTemplate;
import io.github.yujunchengg.okhttps.starter.template.sync.GetTemplate;
import io.github.yujunchengg.okhttps.starter.template.sync.PostTemplate;
import io.github.yujunchengg.okhttps.starter.template.sync.PutTemplate;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * okhttp组件自动配置
 */
@Configuration
@EnableConfigurationProperties(OkHttpsProperties.class)
@ConditionalOnClass({GetTemplate.class, PostTemplate.class})
@ConditionalOnProperty(prefix = "starter.okhttps", value = "enabled", matchIfMissing = true)
@Slf4j
public class OkhttpsAutoConfiguration {

    @Autowired
    private OkHttpsProperties okHttpsProperties;

    @Bean
    @ConditionalOnMissingBean(HTTP.class)
    public HTTP http() {
        HttpClient.Builder builder1 = HTTP.builder();
        if(!Strings.isNullOrEmpty(okHttpsProperties.getBaseUrl())){
            builder1=builder1.baseUrl(okHttpsProperties.getBaseUrl());
        }
        HTTP http= builder1
                .config((Builder builder)->{
                    //配置连接池,默认最大空闲连接为5,
                    builder.connectionPool(
                            new ConnectionPool(
                                    okHttpsProperties.getPool().getMaxIdleConnections(),
                                    okHttpsProperties.getPool().getKeepAliveDuration(),
                                    okHttpsProperties.getPool().getTimeUnit()
                            ));
                    //配置连接超时时间（默认10秒）
                    builder.connectTimeout(okHttpsProperties.getConnectTimeout());
                    //配置读取数据超时时间
                    builder.readTimeout(okHttpsProperties.getReadTimeout());
                    // 配置拦截器
                    builder.addInterceptor((Interceptor.Chain chain) -> {
                        Request request = chain.request();
                        // 必须同步返回，拦截器内无法执行异步操作
                        return chain.proceed(request);
                    });
                    // 其它配置: CookieJar、SSL、缓存、代理、事件监听...
                }).build();
        return http;
    }

    @Bean
    @ConditionalOnMissingBean(GetTemplate.class)
    public GetTemplate getTemplate(){
        return new GetTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(AsyncGetTemplate.class)
    public AsyncGetTemplate asyncGetTemplate(){
        return new AsyncGetTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(PostTemplate.class)
    public PostTemplate postTemplate(){
        return new PostTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(PutTemplate.class)
    public PutTemplate putTemplate(){
        return new PutTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(DeleteTemplate.class)
    public DeleteTemplate deleteTemplate(){
        return new DeleteTemplate();
    }
}
