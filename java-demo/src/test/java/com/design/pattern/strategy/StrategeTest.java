package com.design.pattern.strategy;

import com.design.pattern.strategy.Duck;
import com.design.pattern.strategy.MallardDuck;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class StrategeTest {

	public static void main(String[] args) {
		Duck duck = new MallardDuck();
//   	Duck duck = new RedHeadDuck();
//		Duck duck = new RobbertDuck();
		
		duck.quack();
		duck.display();
		duck.fly();
	}

}
