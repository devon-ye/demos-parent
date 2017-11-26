package com.design.pattern.description.properties;

import com.design.pattern.description.instances.Decorator;
import com.design.pattern.description.instances.AbstractDrink;

/**
*
*@author Devonmusa
*@date   2017年8月8日
*/
public class Milk extends Decorator {

	public Milk(AbstractDrink dirnk) {
		super(dirnk);
		super.setDescription("Milk");
		super.setPrice(6);
	}
		
	 

}
