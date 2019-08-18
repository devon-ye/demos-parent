package org.devon.data.stracture.array;

public class MethodReturnArray {
	public static void main(String[] args) {
		int temp[]=fun();//通过方法实例化数组
		print(temp);     //数组引用传递给方法
	}
	public static int[] fun(){
		int arr[]={12,23,12,43,54,21};
		return arr;
	}
	public static void print(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
