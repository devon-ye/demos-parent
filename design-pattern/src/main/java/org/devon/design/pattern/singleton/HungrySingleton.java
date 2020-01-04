package org.devon.design.pattern.singleton;
/**
 * hungry pattern
 * @author Devon
 */
@ThreadSafe
public class HungrySingleton {
   private static final HungrySingleton hungrySingleton=new HungrySingleton();
   
   private HungrySingleton(){}
   
   public static HungrySingleton getInstance(){
	   return hungrySingleton;
   }
}
