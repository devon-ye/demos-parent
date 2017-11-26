package com.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	private static Scanner scan;
	//private int a[] = { 2, 8, 0, 9, 6, 5, 7 };
	public static void main(String[] args) {
		
		BubbleSort bubbleSort = new BubbleSort();
		scan = new Scanner(System.in);
		int count = scan.nextInt();
		int array[]=produceRandomArray(count);
		int[] arr_b=copyArray(array);
		bubbleSort.sortModeOne(array);
		bubbleSort.sortModeTwo(arr_b);
		bubbleSort.showArray(array);
		
		bubbleSort.showArray(arr_b);

	}
	public static int[] copyArray(int[] array){
		int arr2[]=Arrays.copyOf(array, array.length);
		for(int a:arr2){
			System.out.print(a+"\t");
		}
		System.out.println();
		 return arr2;
	}
    public static int[] produceRandomArray(int count){
    	int arr[]=new int[count];
		for(int i=0;i<arr.length;i++){
			int x =(int) (Math.random()*10000);
			System.out.print(x+"\t");
			arr[i]=x;
		}
		System.out.println();
		return arr;
    }
	public void sortModeOne(int[] a) {
		System.out.print("第一种方式排序前遍历:");
		for(int temp:a){
			System.out.print(temp+"\t");
		}
		long startOne=System.currentTimeMillis();
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j] < a[j + 1]) {
					a[j + 1] = a[j + 1] ^ a[j];
					a[j] = a[j + 1] ^ a[j];
					a[j + 1] = a[j + 1] ^ a[j];

				}
			}
		}
		long endOne=System.currentTimeMillis();
		System.out.print("\n第一种方式排序时间：");
		System.out.println(endOne-startOne);
		
	}
    public void sortModeTwo(int[] b){
    	System.out.print("第二种方式排序前遍历:");
		for(int temp:b){
			System.out.print(temp+"\t");
		}
    	long startTwo=System.currentTimeMillis();
    	int temp = 0;
		for (int i = b.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (b[j] < b[j + 1]) {
					temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;
				}
			}
		}
		long endTwo=System.currentTimeMillis();
		System.out.print("\n"+"第二种方式排序时间：");
		System.out.println(endTwo-startTwo);
    }
	public void showArray(int[] a) {
		for (int arr : a) {
			System.out.print(arr + " ");
		}
		System.out.println();
	}
}
