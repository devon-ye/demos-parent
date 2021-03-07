package org.devon.concurrency.synchronizeds;

import com.google.common.io.Files;

/**
 * @author devon.ye
 * @datetime 2020/2/20 12:22 上午
 * @since
 */
public class SynchronizedAutoReleaseLock {


	/**
	 * 1.class object lock by static method
	 */
	public synchronized static void classLock1(){

	}

	/**
	 * 2.class object lock by code block param class object
	 */
	public  void classLock2(){
		synchronized (SynchronizedAutoReleaseLock.class){

		}
	}

	/**
	 * 2. object instance lock by  method
	 */
	public synchronized void objectInstanceLock1(){
		Files.copy();
	}


	/**
	 * 2. object instance lock by  code block instance param
	 */
	public  void objectInstanceLock2(){
		synchronized(this) {

		}
	}


}
