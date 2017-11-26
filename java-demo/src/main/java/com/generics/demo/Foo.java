package com.generics.demo;

import java.util.ArrayList;
import java.util.List;

/*
*@author  Devonmusa
*@version
*2017年1月25日 下午8:45:19
*
*/
public class Foo {
		
	public void arrayMethod(String[] strArray){
		
	}
	
	public void arrayMethod(Integer[] intArray ) {
		
	}
	
	public void listMethod(List<String> stringList) {
		
	}
	
//	public void listMethod(List<Integer> intList) {
//		
//	}
	
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("abc");
		String str  = list.get(0);
		System.out.println("str:" +str);
	}
	
}

