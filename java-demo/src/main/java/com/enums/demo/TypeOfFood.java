package com.enums.demo;

import com.enums.demo.Food.Appetizer;
import com.enums.demo.Food.Coffee;
import com.enums.demo.Food.Dessert;
import com.enums.demo.Food.MainCourse;

/*
*@author  Devonmusa
*@version
*2017年1月16日 下午10:58:51
*
*/
public class TypeOfFood {
	private static Food food;

	public static void main(String[] args) {
		setFood(Appetizer.SALAD);
		setFood(MainCourse.LASAGNE);
		setFood(Dessert.GELATO);
		setFood(Coffee.CAPPUCCINO);
		for (Appetizer appet : Appetizer.values()) {
			System.out.println(appet);
		}
	}

	public static Food getFood() {
		return food;
	}

	public static void setFood(Food food) {
		TypeOfFood.food = food;
	}

}
