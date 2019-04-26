package org.devon.design.pattern.visitor;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public class Client {

	public static void main(String[] args) {
		
		for(int i = 0; i < 100;i++){
			Element ele = ObjectStruture.createElement();
			ele.accept(new Visitor());
			ele.doSomething();
		}
	}

}
