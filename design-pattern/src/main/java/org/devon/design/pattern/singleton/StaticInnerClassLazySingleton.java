package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author devon.ye
 * @datetime 2020/1/4 7:35 下午
 * @since
 */
@ThreadSafe
public class StaticInnerClassLazySingleton {

	StaticInnerClassLazySingleton(){
		System.out.println("test");
	}

	private static class StaticInnerClass{
		private static final StaticInnerClassLazySingleton singleton = new StaticInnerClassLazySingleton();
	}

	public static StaticInnerClassLazySingleton getInstance(){
		return StaticInnerClass.singleton;
	}

}
