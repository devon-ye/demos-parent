package com.design.pattern.factory.methods;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月18日 下午8:33:28
*
*/
public class Client {

	public static void main(String[] args) {
		IClientFactory clientFactory = new ClientFactory();
		IProduct  product= clientFactory.createProduct();
		product.myProduct();
	}

}
