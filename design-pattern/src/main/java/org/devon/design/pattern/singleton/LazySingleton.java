package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
*@author  devon.ye
*@version
*
*/
@ThreadSafe
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
