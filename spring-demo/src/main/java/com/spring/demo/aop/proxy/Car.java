package com.spring.demo.aop.proxy;

/**
 * Created by lenovo on 2017/12/23.
 */
public class Car implements ICar {

    private String type;

    public Car() {
    }

    public Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println(" this mating car");
    }
}
