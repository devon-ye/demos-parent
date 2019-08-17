package org.devon.design.pattern.strategy;
/**
*
*@author Devonmusa
*@date   2017年5月25日
*/
public class MuteQuack implements QuackStrategy {

	@Override
	public void performanceQuack() {
		System.out.println("MuteQuack");
	}
	
}
