package com.design.pattern.proxy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class CarLorProxy implements Moveable {
	
	private Moveable m;
	public CarLorProxy(Moveable m) {
		this.m = m;
	}
	
	@Override
	public void move() {
		System.out.println("日志开始。。。");
		m.move();
		System.out.println("日志结束。。。");
	}

}
