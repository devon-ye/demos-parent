package org.devon.design.pattern.singleton;

/**
 * @author devon.ye
 * @datetime 2020/1/4 7:49 下午
 * @since
 */
@ThreadSafe
public class DoubleCheckLazySingleton {

   private static volatile DoubleCheckLazySingleton instance;

   public DoubleCheckLazySingleton getInstance(){
   	    if(instance == null){
   	    	synchronized (DoubleCheckLazySingleton.class){
   	    		if(instance == null){
   	    			instance = new DoubleCheckLazySingleton();
				}
			}
		}
   	    return instance;
   }

   DoubleCheckLazySingleton(){}

}
