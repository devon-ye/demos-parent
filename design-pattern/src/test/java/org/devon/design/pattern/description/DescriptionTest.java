package org.devon.design.pattern.description;

import org.devon.design.pattern.description.instances.AbstractDrink;
import org.devon.design.pattern.description.instances.Coffe;
import org.devon.design.pattern.description.properties.Milk;
import org.junit.Test;

/**
*
*@author Devonmusa
*@date   2017年8月8日
*/
public class DescriptionTest {

	@Test
	public  void test() {
		AbstractDrink order ;
		order = new Coffe();
		order.setDescription("coffe");
		order.setPrice(10);
		System.out.println("ORDER PRICE:" + order.getPrice());
		System.out.println("ORDER DESCRIPTION:" + order.getDescription());
		
		Milk milk;
		milk = new Milk(order);
		milk.setDescription("milk");
		milk.setPrice(6);
		System.out.println("Milk PRICE:" + milk.getPrice());
		System.out.println("Milk DESCRIPTION:" + milk.getDescription());
	}

}
