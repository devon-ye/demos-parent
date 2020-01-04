package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author devon.ye
 * @datetime 2020/1/4 7:35 下午
 * @since
 */
@ThreadSafe
public class StaticInnerClassSingleton {
	StaticInnerClassSingleton(){}

	private static class StaticInnerClass{
		private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
	}

	public static StaticInnerClassSingleton getInstance(){
		return StaticInnerClass.singleton;
	}
}
