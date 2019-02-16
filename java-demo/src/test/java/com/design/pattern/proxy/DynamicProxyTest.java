package com.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.design.pattern.proxy.Car;
import com.design.pattern.proxy.Moveable;
import com.design.pattern.proxy.TimeHandler;
import org.junit.Test;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class DynamicProxyTest {

	@Test
	public void test() {
		Car car = new Car();
		TimeHandler invocationHandler = new TimeHandler(car);
		Class<?> class1 =car.getClass();
		System.out.println("target object.hashCode():"+car.hashCode());
		Object moveable =  invocationHandler.createTargetProxyInstance(car.getClass().getInterfaces());
		System.out.println("proxy object:"+moveable);

		//Moveable moveable =  (Moveable) Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), invocationHandler);
	//	moveable.move();

	}

}
