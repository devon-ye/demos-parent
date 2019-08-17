package org.devon.data.string.demo;

import java.util.Random;
import java.util.Scanner;

public class RandomPassword {
   private static 	Random random = new Random();
	public static void main(String[] args) {
		Scanner  scan = new Scanner(System.in);
		int i = scan.nextInt();
		RandomPassword.randoms(i);
	}

	public static String randoms(int i) {
		// 生成随机数,并将随机数字转换为字母
		String sRand = "";

		int count = 0;
		while (count != i) {
			// 循环生成0-122之间的SCII
			int itmp = random.nextInt(123);
			/*
			 * a-z：97-122 A-Z：65-90 0-9：48-57
			 */
			if (itmp >= 48 && itmp <= 57 || itmp >= 65 && itmp <= 90 || itmp >= 97 && itmp <= 122) {
				char ctmp = (char) itmp;
				sRand += String.valueOf(ctmp);
			}
			count = sRand.length();

		}
		return sRand;
	}
}
