package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author devon.ye
 * @datetime 2020/1/4 7:52 下午
 * @since
 */
@ThreadSafe
public class StaticCodeHungrySingleton {
     private static StaticCodeHungrySingleton instance;

     static {
     	instance = new StaticCodeHungrySingleton();
	 }

	 public StaticCodeHungrySingleton getInstance(){
     	return instance;
	 }

	  StaticCodeHungrySingleton(){}

}

