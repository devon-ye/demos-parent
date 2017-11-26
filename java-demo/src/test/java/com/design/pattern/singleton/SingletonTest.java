package com.design.pattern.singleton;

import org.junit.Test;

import com.design.pattern.singleton.ChildSingleton;
import com.design.pattern.singleton.RegisterSingleton;



/**
*@see
*@author  Devonmusa
*@date 2017年4月9日
*/
public class SingletonTest {
	
	@Test
	public void testRegisterSingletonIngetInstance(){
		RegisterSingleton  instance= RegisterSingleton.getInstance("RegisterSingleton");
		System.out.println("intance:" + instance);
	}
	
	@Test
	public void testChildSingletonGetInstance(){
		RegisterSingleton  instance= ChildSingleton.getInstance("RegisterSingleton");
		System.out.println("intance:" + instance);
		
	}
}
