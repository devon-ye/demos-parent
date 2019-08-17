package org.devon.throwable.exception;


/*
*@author  Devonmusa
*@version
*2017年1月22日 下午11:05:31
*
*/
public class ThrowsTest {

	public static void main(String[] args) {
		ThrowsTest test = new ThrowsTest();
		try{
			String str = null;
			String strn =test.get(str);
		}catch(NullPointerException e){
			System.err.println("this is get throw to main's Exception: " + e);
		}
	}

	public  String get(String str) throws NullPointerException{
		
		return str;
	}

}
