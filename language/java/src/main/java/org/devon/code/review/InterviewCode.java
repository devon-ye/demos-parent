package org.devon.code.review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author devon.ye
 * @datetime 2020/2/22 1:30 下午
 * @since
 */

public class InterviewCode {

	private static InterviewCode instance;


	private InterviewCode() {
	}


	public static InterviewCode getInstance() {
		if (instance == null) {
			synchronized (InterviewCode.class) {
				if (instance == null) {
					instance = new InterviewCode();
				}
			}
		}
		return instance;
	}


	public void removeRepeatElement() {

		List<String> list = new ArrayList<String>();
		list.add("123abc23cd");
		list.add("abc24dc123");
		list.add("1234abc");
		list.add("ab1234c2d");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String element = (String) it.next();
			while (it.hasNext()) {
				String element2 = (String) it.next();
//				if(element.regionMatches()){
//
//				}
			}
		}
	}

	public int binarySearch(int[] array, int target) {
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
		int result = InterviewCode.getInstance().binarySearch(new int[]{1, 3, 5, 6}, 5);
		int result2 = InterviewCode.getInstance().binarySearch(new int[]{1}, 1);
		int result3 = InterviewCode.getInstance().binarySearch(new int[]{1}, 3);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);

	}
}
