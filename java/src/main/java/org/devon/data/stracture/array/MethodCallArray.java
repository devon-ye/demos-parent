package org.devon.data.stracture.array;



public class MethodCallArray {

	public static void main(String[] args) {
		int array[]={10,9,18,30,50,20,87};
		arraySort(array);
		print(array);
		//Arrays主要有两种方法sort和search
		//Arrays.sort(array);
		//print(array);

	}
	public static  void  arraySort(int arr[]){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]){
					arr[j]=arr[i]^arr[j];
					arr[i]=arr[i]^arr[j];
					arr[j]=arr[i]^arr[j];	
				}
				
			}
			
		}
	}
    public static void print(int arr[]){
    	System.out.print("排序结果为：");
    	for(int s:arr){
    		
    		System.out.print(s+"\t");
    		
    	}
    }
}
