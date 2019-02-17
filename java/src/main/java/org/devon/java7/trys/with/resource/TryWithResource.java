package org.devon.java7.trys.with.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
*
*@author Devonmusa
*@date   2017年8月8日
*/
public class TryWithResource {
	
	
	public TryWithResource() {
		
	}
	
	public static void openFile() throws FileNotFoundException, IOException{
		File  file =new File("test.xml");
		try{
			file.createNewFile();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fileInputStream = new FileInputStream(file)){
			int number = fileInputStream.read();
			System.out.println("number:" +number);
		}
		
		try(FileInputStream fileInputStream = new FileInputStream(file)){
			int number2 = fileInputStream.read();
			System.out.println("number:" +number2);
		}
		
	}
	
	public static void main(String[] args) {
		try{
			openFile();
		}catch (Exception e) {
			System.out.println("Exception:" +e);
		}
	}

}
