package com.algorithm.sort;

public class NarcissisticNumber {

	
	public void NarcissisticNumbers(){
		int nn=100;
		boolean  flag=true;
		while(flag){ 
			if(nn>999){
				break;
			}else{
			//100-999整数转字符串
			String str=String.valueOf(nn);
			//字符串转字符数组
			char[] chArray=str.toCharArray();
			System.err.print("12="+(chArray[0]+chArray[1]));
			//int a='chArray[0]';
			//System.out.println("a="+a);
			
				
			}
			nn++;
		}
	}

}
