package com.clazz.abstrct;

public class Base {

	public static void main(String[] args) {
		Base base = new Base();
		String str =base.toString();
	}

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