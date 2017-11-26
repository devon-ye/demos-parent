package com.design.pattern.adapter.clazz;

/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月22日 上午12:41:06
*
*/
public class Adapter extends Target{
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	public void request() {
		adaptee.specificRequest();
	}

}
