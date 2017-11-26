package com.algorithm.sort;

public class AllSort {

	public static void main(String[] args) {
		String str = "8396476521";
		dictionarySort(str);
	}

	// 字典序法
	public static void dictionarySort(String str) {
		char buf[] = str.toCharArray();
		int len = buf.length;
		int count = 0;
		//char ch[] = null;
		// 从右边开始取出，左边比右边小的数
		for (int i = len - 1; i >= 0; i--) {
			if (buf[i - 1] < buf[i]) {
				count = i - 1;
				// System.out.print(buf[count] + ",");
				break;
			}
		}
		// 找出左边比右变小的输的，右边比它大的数
		int temp = 0;
		for (int i = count; i < len; i++) {
			if (buf[count] < buf[i]) {
				// System.out.print(buf[i] + ",");
				temp = i;

			}
		}
		// 对换pi，pk
		buf[count] = (char) (buf[count] ^ buf[temp]);
		buf[temp] = (char) (buf[count] ^ buf[temp]);
		buf[count] = (char) (buf[count] ^ buf[temp]);
		// 强pj+1到pk颠倒顺序
		int i = 1;

		for (int j = count + 1; j < len - 2; j++) {

			char c = buf[j];
			// System.out.print("temp=" + c + " ");
			buf[j] = buf[len - i];
			buf[len - i] = c;
			System.out.print(buf[len - i] + " ");
			++i;
			// System.out.println("22222222222");
		}
		for (i = 0; i < len - 2; i++) {
			System.out.print(buf[i] + ",");
		}
		System.out.println();
		// dictionarySort(str);
	}
}
