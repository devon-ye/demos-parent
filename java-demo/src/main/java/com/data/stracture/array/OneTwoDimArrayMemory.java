package com.data.stracture.array;

public class OneTwoDimArrayMemory {

	public static void main(String[] args) {
		OneDimArrayMemory();
		TwoDimArrayMemory();
	}
	public static void OneDimArrayMemory(){
		int num=1024*1024*2;
		int arr[]=new int[num];
		for(int i=0;i<arr.length;i++){
			arr[i]=i;
		}
		long memory=Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("Runtime memory total is"+memory);
	}
	public static void TwoDimArrayMemory() {
		int num2=1024*1024;
		int arr2[][]=new int[num2][2];
		for(int i=0;i<arr2.length;i++){
			arr2[i][0]=i;
			arr2[i][1]=i;
		}
		long memory2=Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("Runtime memory total is"+memory2);
	}

}
