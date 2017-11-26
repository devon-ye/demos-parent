package com.design.pattern.template.methods;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月4日
*/
public class Coffee extends RefreshBeverage {

	@Override
	protected void brew() {
		System.out.println("冲泡咖啡");
	}

	@Override
	protected void addCondiments() {
		System.out.println("将牛奶和糖加入咖啡");
	}

}
