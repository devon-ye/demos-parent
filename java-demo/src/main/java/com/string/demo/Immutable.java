package com.string.demo;

public class Immutable {

	public static void main(String[] args) {
		String q = "howdy";
		System.out.println(q);
		String qq = upCase(q);
		System.out.println(qq);
		System.out.println(q);

	}

	public static String upCase(String s) {
		return s.toUpperCase();
	}

}
