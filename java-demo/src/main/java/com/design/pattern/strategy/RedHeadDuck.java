package com.design.pattern.strategy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		super();
		super.setFlyingStrategy(new FlyWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("this is red head ");
	}

}
