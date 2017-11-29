package com.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
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

}
