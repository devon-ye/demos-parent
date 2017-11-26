package org.devonmusa.util.clazz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassReflectUtil {

	private ClassReflectUtil() {
		throw new Error("ClassReflectUtil class is forbiden instance!");
	}

	/*
	 * 打印类的信息，包括成员函数，成员变量
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void printClassMessage(Object obj) {
		// 1.获取类类型
		Class c = obj.getClass();// 传递的那个子类对象，c是该类类类型
		// 2.获取类名称
		System.out.println("类名称是：" + c.getName());
		// Method类，方法对象
		// 一个成员方法，就是一个Method对象
		// getMethods()获取的是所有的PUBLIC的对象，包括从父类继承来的
		// getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		Method[] ms = c.getMethods();
		c.getDeclaredMethods();
		// System.out.println();
		for (int i = 0; i < ms.length; i++) {
			// 得到方法返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 得到方法的名称
			System.out.print(ms[i].getName() + "(");
			// 获得参数类型---》获得参数列表的类的类类型性
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class cl : paramTypes) {
				System.out.print(cl.getName() + ",");
			}
			System.out.println(")");
		}

	}

	@SuppressWarnings("rawtypes")
	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象 。 java.lang.reflect.Field; Field类封装了关于成员变量的信息；
		 * getFields()获取的是所有的public的成员变量的信息；
		 * getDeclaredFields()获取的是所有该类自己声明的成员变量的信息
		 * 
		 */
		// Field[] fs=c.getFields();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void printConstructorMessage(Object obj) {
		Class c = obj.getClass();
		// Constructor[] cs=c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName() + "(");
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class cpt : paramTypes) {
				System.out.print(cpt.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
