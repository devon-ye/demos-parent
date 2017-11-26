package com.io.demo;


import java.util.Properties;

/**
*@author  Devonmusa
*@date  2017年1月17日
* 
*/
public class SystemEnvromentProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSystemProperties();
	}
	
	public static void printSystemProperties(){
		Properties props = System.getProperties();
		String str=props.toString();
//		str.replaceAll("{", " ");
//		str.replaceAll("}", " ");
		String[] propss = str.split(",");
		
		for(String s:propss)
		System.out.println(s);
	}
	

}
