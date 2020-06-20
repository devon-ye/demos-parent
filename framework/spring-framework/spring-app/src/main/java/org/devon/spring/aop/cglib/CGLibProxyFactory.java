package org.devon.spring.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/12/23.
 */
public class CGLibProxyFactory implements MethodInterceptor {

    private Object target;

    public Object createTarget(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Car car = (Car) target;
        Object result = null;
        String type = car.getType();
        if("mating".equals(type)) {
            result = methodProxy.invoke(target,objects);
        }else {
            System.out.println(" this not mating car!");
        }
        return result;
    }
}
