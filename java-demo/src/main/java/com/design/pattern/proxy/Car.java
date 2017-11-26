package com.design.pattern.proxy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class Car implements Moveable {

	@Override
	public void move() {
		System.out.println("正在走。。。");
	}

}
