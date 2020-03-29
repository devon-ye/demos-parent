package org.devon.algorithms.leetcode;

import java.util.*;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:42
 * @since 1.0.0
 */
public class SumCompute {

	// 借助辅助空间空间换时间
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> integerMap = new HashMap<>(nums.length);
		for (int i = 0, length = nums.length; i < length; i++) {
			int complement = target - nums[i];
			if (integerMap.containsKey(complement)) {
				return new int[]{integerMap.get(complement), i};
			}
			integerMap.put(nums[i], i);

		}
		throw new IllegalArgumentException();
	}

	//利用时间复杂度换空间
	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	//利用时间复杂度换空间
	public static long strToLong(String str) {
		if (str == null) {
			return -1;
		}

		char[] ch = str.toCharArray();
		int flag = 1;

		if (ch[0] == '-') {
			flag = -1;
		}

		int len = ch.length - 1;
		if (ch[len] == 'L' || ch[len] == 'l') {
			len -= 1;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (ch[i] < '0' || ch[i] > '9') {
				if (ch[0] == '-' || ch[0] == '+') {
					continue;
				}
				result.append((int) ch[i]);
			} else {
				result.append(ch[i]);
			}
		}
		return Long.parseLong(result.toString());
	}

	public static void main(String[] args) {
		SumCompute.strToLong("123123DEADWE");
	}
}
