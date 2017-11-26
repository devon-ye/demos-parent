package com.code.review;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 *
 * @author Devonmusa
 * @date 2017年8月5日
 */
public class SqInRect {
	
	private static List<Integer> tempList = null;
	public static List<Integer> sqInRect(int lng, int wdth) {
		List<Integer> intList = null;
		if (tempList != null && wdth != 0) {
			tempList.add(wdth);
			int diff = lng - wdth;
			if (diff < wdth && diff > 0) {
				intList = sqInRect(wdth, diff);

			} else if (diff > 0) {
				intList = sqInRect(diff, wdth);
			}
		}
		if (tempList == null  ) {
			if(lng != wdth) {
			tempList = new ArrayList<>();
			sqInRect(lng, wdth);
			intList = tempList;
			tempList = null;
			}
		}
		return intList;

	}
	
//	public void test1() {
//		List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
//		for (int r : res)
//	//		assertEquals(res, SqInRect.sqInRect(5, 3));
//	}


//	public void test2() {
	//	assertEquals(null, SqInRect.sqInRect(5, 5));
//	}
}