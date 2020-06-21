package org.devon.framework.spring.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "userInfo",cacheManager="cacheManager")
public class OrderServiceImpl implements OrderService {

    @CachePut(unless = "#result == null")
    public void save(OrderEntity entity) {
        log.info("cache info finished:{}", entity);
    }

    @Cacheable(key = "#id")
    public OrderEntity getByKey(Long id) {
        OrderEntity orderEntity = new OrderEntity();
        log.info("cache info getByKey:{}", id);
        orderEntity.setChannel(2);
        orderEntity.setSource(3);
        orderEntity.setOrderSn(id);
        return orderEntity;
    }


    @Cacheable
    public OrderEntity getByKey2(Long id) {
        OrderEntity orderEntity = new OrderEntity();
        log.info("cache info getByKey2:{}", id);
        orderEntity.setChannel(5);
        orderEntity.setSource(4);
        orderEntity.setOrderSn(id);
        return orderEntity;
    }
}
