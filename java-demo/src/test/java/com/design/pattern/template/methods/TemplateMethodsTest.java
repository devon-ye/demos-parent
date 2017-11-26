package com.design.pattern.template.methods;

import org.junit.Test;

import com.design.pattern.template.methods.Coffee;
import com.design.pattern.template.methods.RefreshBeverage;
import com.design.pattern.template.methods.Tea;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月4日
*/
public class TemplateMethodsTest {
	
	@Test
	public void testTemplateMethods() {
		RefreshBeverage refreshBeverage = new Coffee();
		refreshBeverage.prepareBeverrageTemplate();
		
		RefreshBeverage refreshBeverage2 = new Tea();
		refreshBeverage2.prepareBeverrageTemplate();
	}
}
