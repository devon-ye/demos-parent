package com.clazz.reflect;

public class ClassDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// Foo的实例对象
		Foo foo = new Foo();
		// 第一种表达方式
		Class c1 = Foo.class;
		System.out.println(c1);
		// 第二种表达方式
		Class c2 = foo.getClass();
		System.out.println(c2);
		/*
		 * c1,c2表示Foo类的类类型（class type） 万事万物皆对象 类也是对象
		 */
		// 第三种表达方式
		Class c3 = null;
		try {
			c3 = Class.forName("pri.classreflect.demo.Foo");
			try {
				Foo fooS = (Foo) c3.newInstance();
				fooS.print();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(c3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

class Foo {
	void print() {
		System.out.println("FOO");
	}
}