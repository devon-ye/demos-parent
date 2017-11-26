package com.algorithm.compute;


/**
 *
 * @author Devonmusa
 * @date 2017年6月4日
 */
public class Triangle {

	public static boolean isTriangle(int a, int b, int c) {
		return a + b > c && b + c > a && a + c > b;
	}

}
