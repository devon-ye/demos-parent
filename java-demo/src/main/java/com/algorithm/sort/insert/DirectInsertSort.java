package com.algorithm.sort.insert;

/**
 *
 * @author Devonmusa
 * @date 2017年5月23日
 */
public class DirectInsertSort {

	public static int[] insertSort(int array[]) {
		int n = array.length;

		Integer insertValue = null;
		for (int i = 0; i < n; i++) {
			insertValue = array[i];
			for (int j = i; j > 0 && insertValue < array[j - 1]; j--) {
				array[j] = array[j - 1];
				array[j - 1] = insertValue;
			}
		}

		return array;
	}

	public static int[] insertSort(int array[], String sortStrategy) {
		int n = array.length;
		
		for (int i = 0; i < n; i++) {
			if ("asc".equals(sortStrategy)) {
				ascSort(array, i);
			} else if ("desc".equals(sortStrategy)) {
				descSort(array, i);
			}

		}

//		if (sortStrategy == "asc") {
//			for (int i = 0; i < n; i++) {
//				ascSort(array, i);
//			}
//		} else if (sortStrategy == "desc") {
//			for (int i = 0; i < n; i++) {
//				descSort(array, i);
//			}
//		}

		return array;
	}

	private static int[] ascSort(int array[], int index) {
		int insertValue = array[index];
		for (int j = index; j > 0 && insertValue < array[j - 1]; j--) {
			array[j] = array[j - 1];
			array[j - 1] = insertValue;
		}
		return array;
	}

	private static int[] descSort(int array[], int index) {
		int insertValue = array[index];
		for (int j = index; j > 0 && insertValue > array[j - 1]; j--) {
			array[j] = array[j - 1];
			array[j - 1] = insertValue;
		}
		return array;
	}

	public static float[] insertSort(float array[]) {
		int n = array.length;

		Float insertValue = null;
		for (int i = 0; i < n; i++) {
			insertValue = array[i];
			for (int j = i; j > 0 && insertValue < array[j - 1]; j--) {
				array[j] = array[j - 1];
				array[j - 1] = insertValue;
			}
		}
		return array;
	}
	
	
}
