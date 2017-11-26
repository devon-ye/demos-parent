package com.generics.demo;
/**
*
*@author Devonmusa
*@date   2017年8月16日
*/
public class MultiGenericParam <S,T>{
	private  T firstParam;
	private S secondParam;
	
	
	public MultiGenericParam(T firstParam, S secondParam) {
		super();
		this.firstParam = firstParam;
		this.secondParam = secondParam;
	}


	public T getFirstParam() {
		return firstParam;
	}


	public S getSecondParam() {
		return secondParam;
	}


	public void setFirstParam(T firstParam) {
		this.firstParam = firstParam;
	}


	public void setSecondParam(S secondParam) {
		this.secondParam = secondParam;
	}
	
	
	public static void main(String[] args) {
		MultiGenericParam<String,String> multiGenericParam = new MultiGenericParam<String, String>("firstParam", "secondParam"); 
		String firstParam = multiGenericParam.getFirstParam();
		
	}
	
	
}
