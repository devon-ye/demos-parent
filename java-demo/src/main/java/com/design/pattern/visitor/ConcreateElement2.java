package com.design.pattern.visitor;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public class ConcreateElement2 extends Element{

	@Override
	public void doSomething() {
		System.out.println("ConcreateElement2 doing something...");
	}

	@Override
	public void accept(IVisitor visitor) {
		System.out.println("ConcreateElement2 visiting this...");
	}

}
