package com.design.pattern.NullObject;

import org.junit.Test;

import com.design.pattern.nullobject.Animal;
import com.design.pattern.nullobject.NullObject;
import com.design.pattern.nullobject.Tiger;

/**
*@see
*@author  Devonmusa
*@date 2017年4月11日
*/
public class NullObjectTest {
	@Test
	public Animal test(Tiger tiger){
		if(tiger != null){
			return tiger;
		}else{
			return new NullObject();
		}
	}
}
