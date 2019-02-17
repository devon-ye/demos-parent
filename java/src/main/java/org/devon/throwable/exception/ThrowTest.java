package org.devon.throwable.exception;


/**
*@author  Devonmusa
*@date 2017年1月22日
*/
public class ThrowTest {
	public static void main(String[] args) {
		ThrowTest test = new ThrowTest();
		try {
			test.testThrowNullException();
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				System.err.println("this is just throw NullPointerException Instance Object");
			} else {
				System.err.println("I don't know,what it is?");
			}
		}

	}

	public Exception testThrowNullException() {
		throw new NullPointerException("this is myself throw NullPointerException,you needn't to do anything");
	}
}
