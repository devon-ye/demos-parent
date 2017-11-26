package com.design.pattern.singleton;

import com.design.pattern.prototype.Client;

/**
 *
 * @author Devonmusa
 * @date 2017年8月16日
 */
public class GenericLazySingleton<T> {
	private  T t;

	public   synchronized T getSingleton(Class<T> clazz) {

		if (t == null) {
      
			try {
				t = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				
			}
		}

		return t;
	}
	
	
	
	public static void main(String[] args) {

		GenericLazySingleton genericLazySingleton = new GenericLazySingleton<>();

		Client client = (Client) genericLazySingleton.getSingleton(Client.class);
	}

}
