package org.devon.design.pattern.singleton;

/**
*lazy pattern  is unsafe , when it run mutil Thread
*@author  Devonmusa
*@version
*2017年2月18日 下午7:43:48
*
*/

public class LazySingleton {
	
	private static LazySingleton lazySingleton=null;
	
	private LazySingleton(){}
	
	public static synchronized LazySingleton getInstance(){
		if(lazySingleton==null){
			lazySingleton=new LazySingleton();
		}
		return lazySingleton;
	}
}
