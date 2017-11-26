package com.design.pattern.singleton;

/**
 * 
 * @author Devonmusa
 * @date 2017年4月9日
 */
public class ChildSingleton extends RegisterSingleton {
	
	public ChildSingleton(){} 
	
	static public ChildSingleton getInstance() {
		return (ChildSingleton) RegisterSingleton.getInstance("ChildSingleton");
	}
}
