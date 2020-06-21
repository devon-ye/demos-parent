package org.devon.framework.spring.boot.controller;

import lombok.Data;

import java.io.Serializable;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
@Data
public class OrderEntity implements Serializable {
    private Long id;
    private Long orderSn;
    private Integer type;
    private Integer source;
    private Integer channel;


}
