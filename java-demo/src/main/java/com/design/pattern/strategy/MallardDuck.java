package com.design.pattern.strategy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class MallardDuck extends Duck {
	
	
	
	public MallardDuck() {
		super();
		super.setFlyingStrategy(new FlyWithWin());
		super.setQuackStrategy(new Squeak());
		
	}
	@Override
	public void display() {
		System.out.println("this is yeallow");
	}

}
