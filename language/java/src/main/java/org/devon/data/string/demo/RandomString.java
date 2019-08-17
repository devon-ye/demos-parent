package org.devon.data.string.demo;

import java.util.Random;

public class RandomString {
    private static Random rn = new Random();
	@SuppressWarnings("deprecation")
	public static String randomstring(int lo, int hi) {
		int n = rand(lo, hi);
		byte b[] = new byte[n];
		for (int i = 0; i < n; i++) {
			b[i] = (byte) rand('a', 'z');
		}
		return new String(b, 0);
	}

	private static int rand(int lo, int hi) {

		int n = hi - lo + 1;
		int i = rn.nextInt(n);
		if (i < 0) {
			i = -i;
		}
		return lo + i;
	}

	public static String randomstring() {
		return randomstring(5, 25);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(randomstring());
	}

}