package com.design.pattern.singleton;
/**
 * hungry pattern
 * @author Devon
 * @time 2016/9/2 00:09
 */
public class HungrySingleton {
   private static final HungrySingleton hungrySingleton=new HungrySingleton();
   
   private HungrySingleton(){}
   
   public static HungrySingleton getInstance(){
	   return hungrySingleton;
   }
}
