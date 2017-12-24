package com.spring.demo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2017/12/23.
 */
public class ProxyFactory implements InvocationHandler {
    private Object target;

    public Object createTargetProxy(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Car car = (Car) target;
        Object object = null;
        String type = car.getType();
        if("mating".equals(type)) {
            object = method.invoke(target,args);
        }else {
            System.out.println("car type is mating");
        }
        return object;
    }
}
