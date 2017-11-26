package com.design.pattern.visitor;

import java.util.Random;

/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public class ObjectStruture {
	
	public static Element createElement(){
		Random rand = new Random();
		if(rand.nextInt(100) > 50){
			return new ConcreateElement1();	
		}else{
			return new ConcreateElement2();	
		}
	}
}
