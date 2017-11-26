package com.design.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see
 * @author Devonmusa
 * @date 2017年4月8日
 */
public class RegisterSingleton {
	private static Logger LOG = LoggerFactory.getLogger(RegisterSingleton.class);

	private static Map<String, Object> singletonRegistry = new HashMap<String, Object>();

	protected RegisterSingleton() {

	}

	public static RegisterSingleton getInstance(String name) {
		if (name == null) {
			name = "default-singleton";
		}
		if (singletonRegistry.get(name) == null) {

			try {
				singletonRegistry.put(name, Class.forName(name).newInstance());
			} catch (InstantiationException e) {
				LOG.error("get instance failed!,InstantiationException:" + e);
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error("get instance failed!, IllegalAccessException:" + e);
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				LOG.error("get instance failed!,ClassNotFoundException:" + e);
				e.printStackTrace();
			}
		}
		return (RegisterSingleton) singletonRegistry.get(name);
	}

	public void doSomething() {
		/**
		 * other method
		 */
	}

}
