package com.data.string.demo;

public class LowerUpperCaseDemo {
	public final static String str = "sadDAFAFfsfdsfdDDdaDAad";

	public static void main(String[] args) {
		upLower();
	}

	public static void upLower() {
		System.out.println("源字符串" + str);
		System.out.println("用toLowerCase()方法全部转换成小写：" + str.toLowerCase());
		System.out.println("用toUpperCase()方法全部转换成大写：" + str.toUpperCase());
		System.out.println(str);
		System.out.println("-----------非toLowerCase和toUpperCase转换后的结果------------");
		char[] ch = str.toCharArray();
		// 转为小写
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] += 32;
			}
		}
		String str = new String(ch);
		System.out.println(str);
		// 转为大写
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] -= 32;
			}
		}
		String strs = new String(ch);
		System.out.println(strs);

	}
}
