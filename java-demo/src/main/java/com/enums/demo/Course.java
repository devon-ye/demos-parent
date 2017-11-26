package com.enums.demo;



/**
*@author  Devonmusa
*@date 2017年1月16日 下午11:17:08
*
*/
public enum Course {
	
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	
	Course(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
		
	}
	
//	public Food randomSelection() {
//		return Enum.random(values);
//	}
}
