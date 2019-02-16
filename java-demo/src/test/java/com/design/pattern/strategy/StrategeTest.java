package com.design.pattern.strategy;

import com.design.pattern.strategy.Duck;
import com.design.pattern.strategy.MallardDuck;
import org.junit.Test;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class StrategeTest {

	@Test
	public void test() {
		Duck duck = new MallardDuck();
//   	Duck duck = new RedHeadDuck();
//		Duck duck = new RobbertDuck();
		
		duck.quack();
		duck.display();
		duck.fly();
	}

}
