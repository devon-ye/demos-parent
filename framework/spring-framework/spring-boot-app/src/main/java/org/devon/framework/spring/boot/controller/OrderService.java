package org.devon.framework.spring.boot.controller;


/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
public interface OrderService {

    void save(OrderEntity entity) ;

     OrderEntity getByKey(Long id) ;

     OrderEntity getByKey2(Long id);
}
