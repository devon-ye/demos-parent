package com.clazz.abstrct;

public class Base {

}

abstract class A {

}

class B extends A {
	public void print() {

	}

	static void aMethod(A a) {
		A aaa = new B();
		System.out.println(aaa.hashCode());
	}
}