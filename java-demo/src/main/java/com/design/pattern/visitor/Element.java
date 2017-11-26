package com.design.pattern.visitor;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public abstract class Element {
	
	/**
	 * define business logic
	 */
	public abstract void doSomething();
	
	/**
	 * allowed,who can visitor this 
	 * 
	 * @param visitor
	 */
	public abstract void accept(IVisitor visitor);
}
