package org.devon.code.review;

import java.util.Random;

/**
 * @author devon.ye
 * @datetime 2020/2/21 11:54 上午
 * @since
 */
public class PrintLeeter {

	private Object object = new Object();

	private Random random = new Random();


	public String print() {
		int rate = random.nextInt(9);
		if (rate < 3) {
			return "a";
		} else {
			return "b";
		}
	}

	public static int binarySearch(int[] array, int target) {
		if (array == null) {
			return -1;
		}

		int startIndex = 0;
		int endIndex = array.length - 1;

		while (startIndex <= endIndex) {
			int mid = (startIndex + endIndex) / 2;
			if (target > array[mid]) {
				startIndex = mid + 1;
			} else if (target < array[mid]) {
				endIndex = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;


	}
	public static void main(String[] args) {

		int rssult = PrintLeeter.binarySearch(new int[]{1, 5, 8, 9}, 9);
		System.out.println(rssult);


	}


}
