package com.design.pattern.observer;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月26日
*/
public class ConcreteObserver implements Observer{
	
	private String observerState;
	@Override
	public void update(Subject subject) {
		observerState = ((ConcreteSubject)subject).getSujectState();
		 print();
	}
	
	public void print(){
		System.out.println(this.getClass()+"    said:"+this.observerState);
	}

}
