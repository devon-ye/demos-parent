package org.devon.design.pattern.visitor;

import java.util.Random;

/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public class ObjectStruture {
	private static Random rand = new Random();
	public static Element createElement(){
		if(rand.nextInt(100) > 50){
			return new ConcreateElement1();	
		}else{
			return new ConcreateElement2();	
		}
	}
}
