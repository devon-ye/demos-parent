package com.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.design.pattern.proxy.Car;
import com.design.pattern.proxy.Moveable;
import com.design.pattern.proxy.TimeHandler;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class DynamicProxyTest {

	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler invocationHandler = new TimeHandler(car);
		Class<?> class1 =car.getClass();
		Moveable moveable =  (Moveable) Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), invocationHandler);
		moveable.move();

	}

}
