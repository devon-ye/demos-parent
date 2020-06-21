package org.devon.framework.spring.boot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
@Slf4j
@Configurable
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Bean(name = "cacheManager")
    public CacheManager cacheManager(@Qualifier("redisConnectionFactory") RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory);
        log.info("-----------init cacheManager cacheNames:{}", redisCacheManager.getCacheNames());
        log.info("------------init cacheManager config:{}", redisCacheManager.getCacheConfigurations());
        return redisCacheManager;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }


    @Nullable
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            log.info("");
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(getCacheKey(obj));
            }
            log.info("cacheKey={}", sb.toString());
            return sb.toString();
        };
    }

//    @Nullable
//    public CacheResolver cacheResolver() {
//        return null;
//    }
//
//    @Nullable
//    public CacheErrorHandler errorHandler() {
//        return null;
//    }


    @Bean("redisConnectionFactory")
    public RedisConnectionFactory factory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        //configuration.setPassword();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration);

        return factory;
    }

    public static String getCacheKey(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class clazz = obj.getClass();
        if (clazz.equals(String.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(ArrayList.class)
        ) {
            return obj.toString();
        }

        try {
            Method method = clazz.getDeclaredMethod("cacheKey");
            return (String) method.invoke(obj);
        } catch (Exception e) {
            log.warn("invoke cacheKey method fail, use default toString as cacheKey:", e);
            return obj.toString();
        }
    }


    @Bean(name = "redisConfig")
    public RedisCacheConfiguration cacheConfiguration() {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        cacheConfiguration.entryTtl(Duration.ofMinutes(5));
        // cacheConfiguration.computePrefixWith(CacheKeyPrefix.simple())
        cacheConfiguration.disableCachingNullValues();
        return cacheConfiguration;
    }
}
