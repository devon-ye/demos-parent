package com.design.pattern.strategy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class FlyNoWay implements FlyingStrategy {

	@Override
	public void performanceFly() {
		System.out.println("我 不会  飞！！！");
	}

}
