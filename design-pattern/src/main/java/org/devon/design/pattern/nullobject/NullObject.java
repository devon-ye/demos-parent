package org.devon.design.pattern.nullobject;
/**
*@see
*@author  Devonmusa
*@date 2017年4月11日
*/
public class NullObject extends Animal implements Nullable{
    private boolean isNull;
	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void call() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNull() {
		return this.isNull;
	}

	@Override
	public void setNull(boolean isNull) {
         this.isNull = isNull;
	}
}
