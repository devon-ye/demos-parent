package org.devon.code.review;


import java.util.ArrayList;
import java.util.List;



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
}