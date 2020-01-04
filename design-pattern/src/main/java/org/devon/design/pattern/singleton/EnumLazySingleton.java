package org.devon.design.pattern.singleton;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author devon.ye
 * @datetime 2020/1/4 7:34 下午
 * @since
 * @Description  具备防止反射和反序列化破坏单例对象的能力
 */
@ThreadSafe
public enum EnumLazySingleton {

	INSTANCE;



	EnumLazySingleton(){};
}
