package com.design.pattern.template.methods;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月4日
*/
public class Tea extends RefreshBeverage {

	@Override
	protected void brew() {
		System.out.println("冲泡茶叶");
	}

	@Override
	protected void addCondiments() {
		System.out.println("将柠檬倒入杯中");
		
	}
    
	
	public boolean isCustomerAddCondiments() {
		return false;
	}

}
