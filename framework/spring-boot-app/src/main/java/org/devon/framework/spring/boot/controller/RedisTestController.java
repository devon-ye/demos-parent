package org.devon.framework.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author devon.ye
 * @datetime 2020/1/5 11:12 上午
 * @since
 */
@RestController
public class RedisTestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/hello")
    public String hello() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderSn(Long.MAX_VALUE);
        orderService.getByKey(4567L);
        orderService.getByKey2(456456L);
        orderService.save(orderEntity);

        return "hello http2";
    }
}
