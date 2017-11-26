package com.design.pattern.strategy;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class FlyWithWin implements FlyingStrategy{

	@Override
	public void performanceFly() {
		System.out.println("用翅膀高飞");
	}
	
	
}
