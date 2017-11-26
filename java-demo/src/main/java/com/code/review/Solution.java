package com.code.review;

import java.util.stream.IntStream;

/**
 *
 * @author Devonmusa
 * @date 2017年8月5日
 */
public class Solution {

	public static String isSortedAndHowMy(int[] array) {
		int sum = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] < array[i]) {
				sum += 1;
			} else {
				sum += 0;
			}
		}

		if (sum == 0) {
			return "yes, descending";
		} 
		
		if (sum == array.length) {
			return "yes, ascending";
		} 
		
		return "no";
	
	}

	public static String isSortedAndHow(int[] array) {
		if (IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]))
			return "yes, ascending";

		if (IntStream.range(0, array.length - 1).allMatch(i -> array[i] >= array[i + 1]))
			return "yes, descending";

		return "no";
	}

}
