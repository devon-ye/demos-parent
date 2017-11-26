package com.design.pattern.factory.methods;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月18日 下午8:20:29
*
*/
public class Product implements IProduct{

	@Override
	public void myProduct() {
		System.out.println("this factory pattern produce product...");	
	}

}
