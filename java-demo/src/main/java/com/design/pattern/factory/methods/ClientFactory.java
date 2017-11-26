package com.design.pattern.factory.methods;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月18日 下午8:13:45
*
*/
public class ClientFactory implements IClientFactory{

	
	public IProduct createProduct() {
		
		return new Product();
	}

}
