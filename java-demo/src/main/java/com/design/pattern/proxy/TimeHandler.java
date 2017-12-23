package com.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年2月25日
*/
public class TimeHandler implements InvocationHandler {
	/**
	 * 
	 */
	
	private Object target;
	
	
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	public Object createTargetProxyInstance(Object target){
	    this.target = target;
	    return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("日志开始。。。");
		method.invoke(target);
		System.out.println("日志结束。。。");
		return null;
	}



}
