package com.spring.demo.aop.proxy;

/**
 * Created by lenovo on 2017/12/23.
 */
public class ProxyMain {

    public static void main(String[] args) {
        ICar car = new Car("mating");
        ProxyFactory proxyFactory = new ProxyFactory();
    }
}
