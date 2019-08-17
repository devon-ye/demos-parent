package org.devon.enums.demo;

/*
*@author  Devonmusa
*@version
*2017年1月16日 下午10:58:51
*
*/
public class TypeOfFood {
	private static Food food;

	public static void main(String[] args) {
		setFood(Food.Appetizer.SALAD);
		setFood(Food.MainCourse.LASAGNE);
		setFood(Food.Dessert.GELATO);
		setFood(Food.Coffee.CAPPUCCINO);
		for (Food.Appetizer appet : Food.Appetizer.values()) {
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
