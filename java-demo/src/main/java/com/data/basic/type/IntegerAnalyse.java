package com.data.basic.type;



/**
*
*@author Devonmusa
*@date   2017年8月6日
*/
public class IntegerAnalyse {
	
	

	public static void testIntegerCache() {
	//	System.setProperty("java.lang.Integer.IntegerCache.high", "1000");
		 Integer int1 = 128;
		 Integer int2 = 128;
		 if(int1 == int2) {
			 System.out.println("this is equals object");
		 }
		 
		 
		 
	}
	
	public static void main(String[] args) {
		
		System.setProperty("java.lang.Integer.IntegerCache.high", "1000");
		String str = System.getProperty("java.lang.Integer.IntegerCache.high");
		String str1= sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
		SecurityManager securityManager = System.getSecurityManager();
		testIntegerCache();
	}

}
