package com.generics.demo;



/*
*@author  Devonmusa
*@version
*2017年1月21日 下午12:04:00
*
*/
public class Holder<T> {
	private T a;
	
	public Holder(T a) {
		this.a = a;
	}
	
	public void set(T a) {
		this.a = a;
	}
	
	public T get() {
		return a;
	}
	
	public static void main(String[] args) {
		Holder<AutoMobile> holder = new Holder<AutoMobile>(new AutoMobile());
		AutoMobile a = holder.get();
		//holder.set("not is  type");
		//holder.set(1);
		a.setType("this is type");
		//PrintUtil.print("a.getType():" + a.getType());
			
	}

}
