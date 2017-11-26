package com.throwable.exception.nullpointexception;

public class StrNullPointException {

	public static void main(String[] args) {
       StrNullPointException nullPointException=new StrNullPointException();
       String str = null;
       nullPointException.StrNull(str);
	}
     
	public void  StrNull(String str){
		/*
		 *   bug str.equals("123")
		 */
		if(str!=null&&"123".equals(str)){
			System.out.println("Null Point Exception");
		}else{
			System.out.println("NOT Null Point Exception");
		}
	}
}
