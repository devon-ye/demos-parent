package com.algorithm.sort;

import java.util.Scanner;

public class LinkedListDemo1 {

	// private LinkedListDemo1 lld= new LinkedListDemo1();
	static int array[] = null;

	public static void main(String[] args) {
		LinkedListDemo1 LinkedListDemo1 = new LinkedListDemo1();
		LinkedListDemo1.init();
	}

	public void init() {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		array[l] = LinkedListDemo1.ProductArray(l);
		LinkedListDemo1.LinkedListArrarSum(array);
	}

	public static void LinkedListArrarSum(int[] array) {
		int temp = 0;
		int sum = 0;
		int j = array.length - 1;
		for (int i = 0; i < j - 1; i++) {
			temp = array[i] + array[j - i];
			sum += temp;
			System.out.print("temp=" + temp + " ");
		}
		System.out.println("sum=" + sum);

	}

	public static int ProductArray(int l) {
		int array[] = new int[l];
		for (int i = 0; i <= l - 1; i++) {
			array[i] = i;
			System.out.print(array[i] + "  ");
		}
		return array[l];

	}

}
