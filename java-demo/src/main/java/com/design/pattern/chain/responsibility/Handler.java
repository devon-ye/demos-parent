package com.design.pattern.chain.responsibility;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月1日
*/
public abstract class Handler {
	protected Handler succesor;
	
	public void setSuccesor(Handler succesor) {
		this.succesor = succesor;
	}

	public abstract void processDiscount(float discount);

	
}
