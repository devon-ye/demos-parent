package org.devon.design.pattern.singleton;

import org.junit.Test;

/**
 * @author devon.ye
 * @datetime 2020/4/1 10:06 上午
 * @since
 */
public class StaticInnerClassLazySingletonTest {

	@Test
	public void getInstance() {
		StaticInnerClassLazySingleton instance = StaticInnerClassLazySingleton.getInstance();
	}
}