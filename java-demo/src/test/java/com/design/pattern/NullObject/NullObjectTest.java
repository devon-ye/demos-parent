package com.design.pattern.NullObject;

import org.junit.Ignore;
import org.junit.Test;

import com.design.pattern.nullobject.Animal;
import com.design.pattern.nullobject.NullObject;
import com.design.pattern.nullobject.Tiger;

/**
*@see
*@author  Devonmusa
*@date 2017年4月11日
*/
@Ignore
public class NullObjectTest {
	@Test
	public Animal test(){
		Tiger tiger= null;
		if(tiger != null){
			return tiger;
		}else{
			return new NullObject();
		}
	}
}
