package org.devon.clazz.inner;

import org.junit.Test;

/**
*
*@author Devonmusa
*@date   2017年7月8日
*/
public class InnerClassTest {

	@Test
	public  void testInner() {
		InnerClass innerClass = new InnerClass();
		
		InnerClass.InnerClassA innerClassA = innerClass.new InnerClassA();
		
		InnerClass.InnerClassB innerClassB = innerClass.new InnerClassB();
		
		InnerClass.InnerClassB.InnerClassC innerClassC = innerClassB.new InnerClassC();
		
		System.out.println("innerClass=" + innerClass +", innerClassA="+ innerClassA +",innerClassB=" + innerClassB + ", innerClass=" + innerClassC);

	}

}
