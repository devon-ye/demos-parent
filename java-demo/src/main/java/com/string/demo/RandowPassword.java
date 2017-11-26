package com.string.demo;

import java.util.Random;
import java.util.Scanner;

public class RandowPassword {

	public static void main(String[] args) {

		Scanner  scan = new Scanner(System.in);
		int i = scan.nextInt();
		RandowPassword.randoms(i);
	}

	public static void randoms(int i) {
		// 生成随机数,并将随机数字转换为字母
		String sRand = "";
		Random random = new Random();
		int count = 0;
		while (count != i) {
			// do {
			// 循环生成0-122之间的SCII
			int itmp = random.nextInt(123);
			/*
			 * a-z：97-122 A-Z：65-90 0-9：48-57
			 */
			// System.out.print(itmp + " ");

			if (itmp >= 48 && itmp <= 57 || itmp >= 65 && itmp <= 90 || itmp >= 97 && itmp <= 122) {
				char ctmp = (char) itmp;
				sRand += String.valueOf(ctmp);
			}
			count = sRand.length();

		}
		// System.out.println();
		System.out.println(sRand);
	}
}
