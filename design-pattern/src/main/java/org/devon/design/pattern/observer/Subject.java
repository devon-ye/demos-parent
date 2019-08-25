package org.devon.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
*@author  Devonmusa
*@date 2017年2月26日
*/
public class Subject {
	
	private List<Observer> observers =new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void dettach(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObserver() {
		for(Observer observer:observers) {
			observer.update(this);
		}
	}
}
