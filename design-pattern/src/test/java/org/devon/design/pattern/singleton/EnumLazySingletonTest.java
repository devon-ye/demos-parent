package org.devon.design.pattern.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author devon.ye
 * @datetime 2020/4/1 10:15 上午
 * @since
 */
public class EnumLazySingletonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test(){
		EnumLazySingleton lazySingleton = EnumLazySingleton.INSTANCE;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.reverse();
			EnumLazySingleton ss =EnumLazySingleton.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}