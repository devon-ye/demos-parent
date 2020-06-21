package org.devon.framework.spring.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.devon.framework.spring.boot.controller.OrderEntity;

import java.util.List;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
@Mapper
public interface OrderMapper {

    void insert(OrderEntity entity);

    List<OrderEntity> selectByPrimaryKey(Long id);
}
