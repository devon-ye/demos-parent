package org.devon.design.pattern.template.methods;

import org.junit.Test;

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
