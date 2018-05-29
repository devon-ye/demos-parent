package com.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {



	public static void  itratorMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "saas");
		map.put("2", "3223");
		map.put("4", "sw");

		for (String s : map.keySet()) {
			System.out.print(s + "=" + map.get(s) + "   ");

		}
		System.out.println();
		System.out.println("***********************************");
		for (String values : map.values()) {
			System.out.print(values + "   ");
		}
		System.out.println();
		System.out.println("***********************************");
		/**
		 * 方法三遍历map，推荐使用该方法遍历map集合，尤其是容量大时
		 */
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "=" + entry.getValue() + "  ");
		}
		//方法四
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		Iterator< Map.Entry<String,String>> iterator =  entrySet.iterator();
		while (iterator.hasNext()){
			Map.Entry<String,String> entry = iterator.next();
			entry.getKey();
			entry.getValue();
		}
	}


	public static void  mapTrap(){
		Map<String,String>  stringStringMap = new HashMap<>();
		Integer num20 = new Integer(20);
		stringStringMap.put("20","贰拾");
		/**
		 * trap1 : map string key 20 not equals  integer 20;
		 */
		if(stringStringMap.containsKey(num20)){
			System.out.println("map string key 20  equals  integer 20");
		}else {
			System.out.println("map string key 20  not equals  integer 20");
		}

		/**
		 * trap2 : key type error,so it can't get value;
		 */
		String  valueStr =  stringStringMap.get(num20);
		if(valueStr == null){
			System.err.println("error type can't get value,so value is null");
		}else {
			System.out.println(" map value is:"+valueStr);
		}

		String  valueStr2 =  stringStringMap.get(num20.toString());
		if(valueStr2 == null){
			System.err.println("error type can't get value,so value is null");
		}else {
			System.out.println(" map value is:"+valueStr2);
		}

	}

	public static void main(String[] args) {
          HashMapDemo.mapTrap();
	}


}
