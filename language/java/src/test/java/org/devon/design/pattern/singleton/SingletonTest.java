package org.devon.design.pattern.singleton;

import org.junit.Ignore;
import org.junit.Test;




/**
*@see
*@author  Devonmusa
*@date 2017年4月9日
*/
@Ignore
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
