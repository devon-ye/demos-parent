package org.devon.design.pattern.observer;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月26日
*/
public class ConcreteSubject extends Subject {
	
	private String sujectState;

	public String getSujectState() {
		return sujectState;
	}

	public void setSujectState(String sujectState) {
		this.sujectState = sujectState;
		this.notifyObserver();
	}
	
}
