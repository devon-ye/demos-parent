package org.devon.design.pattern.visitor;



import org.devon.design.pattern.visitor.Element;
import org.devon.design.pattern.visitor.ObjectStruture;
import org.devon.design.pattern.visitor.Visitor;
import org.junit.Test;


/**
*@see
*@author  Devonmusa
*@date 2017年4月11日
*/
public class VisitorPatternTest {
	
	@Test
	public  void  testVisitors(){
		for(int i = 0; i < 100;i++){
			Element ele = ObjectStruture.createElement();
			ele.accept(new Visitor());
			ele.doSomething();
		}
	}
}
