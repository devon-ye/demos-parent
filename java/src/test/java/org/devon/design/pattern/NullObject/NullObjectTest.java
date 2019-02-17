package org.devon.design.pattern.NullObject;

import org.devon.design.pattern.nullobject.Animal;
import org.devon.design.pattern.nullobject.NullObject;
import org.devon.design.pattern.nullobject.Tiger;
import org.junit.Ignore;
import org.junit.Test;

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
