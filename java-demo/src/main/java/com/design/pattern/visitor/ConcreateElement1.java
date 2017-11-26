package com.design.pattern.visitor;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public class ConcreateElement1 extends Element {

	@Override
	public void doSomething() {
		System.out.println("ConcreateElement1 doing something...");
	}

	@Override
	public void accept(IVisitor visitor) {
		System.out.println("ConcreateElement1 visiting this...");
	}

}
