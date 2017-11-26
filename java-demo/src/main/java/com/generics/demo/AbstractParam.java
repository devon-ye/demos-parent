package com.generics.demo;
/**
*
*@author Devonmusa
*@date   2017年8月16日
*/
public abstract class AbstractParam<T> {
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
