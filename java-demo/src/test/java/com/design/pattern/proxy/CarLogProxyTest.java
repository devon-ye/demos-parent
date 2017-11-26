package com.design.pattern.proxy;

import com.design.pattern.proxy.Car;
import com.design.pattern.proxy.CarLorProxy;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class CarLogProxyTest {

	public static void main(String[] args) {
		Car car = new Car();
		CarLorProxy carLorProxy = new CarLorProxy(car);
		carLorProxy.move();
	}

}
