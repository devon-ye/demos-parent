package org.devon.solution.distributed.tracing.spring.config;

import feign.Feign;
import feign.hystrix.HystrixFeign;
import okhttp3.ConnectionPool;
import org.devon.solution.distributed.tracing.openfegin.TracingFeignInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

/**
 * @author chensk
 * @date 2020/5/6
 */
public class EnableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder(@Qualifier("feignOkhttpClient") feign.okhttp.OkHttpClient okHttpClient) {
        return HystrixFeign.builder().client(okHttpClient).requestInterceptor(new TracingFeignInterceptor());
    }


    @Bean(name ="feignOkhttpClient")
    public feign.okhttp.OkHttpClient okHttpClient() {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(30,60,TimeUnit.SECONDS))
                .build();
        return new feign.okhttp.OkHttpClient(client);
    }
}
