package com.algorithm.compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @see
 * @author Devonmusa
 * @date 2017年3月15日
 */
public class CommonDivisorUtils {
	private static Scanner scanner;
	private static List<Integer[]> inputs;

	/**
	 * 
	 * this is get
	 * 
	 */
	public static int getConmmonDivisorCountOfInputX() {
		List<Integer[]> integers = getInput();
		for (Integer[] ints : integers) {
			if (ints[0] / ints[1] == 0 && ints[2] / ints[3] == 0) {

			}
		}

		return 0;
	}

	private static List<Integer[]> getInput() {
		String inputStr = null;
		inputs = new ArrayList<Integer[]>();


		int groupCount = 1;
		int i = 0;
		while (i < groupCount) {
			inputStr ="10,9,1,7";
			String[] strings = inputStr.split(",");
			Integer[] dataGroup = new Integer[4];
			for (int j = 0; j < 4; j++) {
				dataGroup[j] = Integer.parseInt(strings[j]);
			}
			i++;
			inputs.add(dataGroup);
		}
		return inputs;
	}

}
