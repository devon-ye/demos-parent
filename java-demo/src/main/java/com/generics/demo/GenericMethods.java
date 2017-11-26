package com.generics.demo;



/**
*@author  Devonmusa
*@version
*2017年2月7日 下午11:40:02
*
*/
public class GenericMethods {
	
	public <T> void f(T x) {
		//PrintUtil.print(x.getClass().getName());
	}
	
	public static void main(String[] args) {
		GenericMethods genericMethods = new GenericMethods();
		genericMethods.f(" ");
		genericMethods.f(1);
		genericMethods.f(1.00);
		genericMethods.f(1.0F);
		genericMethods.f('c');
		genericMethods.f(genericMethods);

	}

}
