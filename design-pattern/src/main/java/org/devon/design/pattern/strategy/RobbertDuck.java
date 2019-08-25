package org.devon.design.pattern.strategy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class RobbertDuck extends Duck {
	
	public RobbertDuck() {
		super();
	    super.setFlyingStrategy(new FlyNoWay());
	}
	
	@Override
	public void display() {
		System.out.println("this is all yeallow");
	}
	
	public void quack(){
		System.out.println("嘎~嘎~嘎！！！");
	}

}
