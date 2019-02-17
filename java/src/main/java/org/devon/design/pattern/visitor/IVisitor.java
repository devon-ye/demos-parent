package org.devon.design.pattern.visitor;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public interface IVisitor {
	/**
	 * could visit object
	 * @param element1
	 */
    void visit(ConcreateElement1 element1);
	
	void visit(ConcreateElement2 element2);
}
