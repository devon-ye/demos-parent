package com.collections.set;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetTest {
	private static Scanner in;

	public static void main(String[] args) throws FileNotFoundException {
		Set<String> words = new HashSet<String>();
		// 通过输入流代开文献
		// 方法1:这个方法不需要抛出异常
		InputStream inStream = SetTest.class.getResourceAsStream("NewFile.xml");
		// 方法2：这个方法需要抛出异常
		// InputStream inStream = new
		// FileInputStream("D:\\Documents\\workspace\\JAVAStudy\\src\\edu\\sjtu\\erplab\\collection\\Alice.txt");
		in = new Scanner(inStream);
		while (in.hasNext()) {
			words.add(in.next());
		}
		Iterator<String> iter = words.iterator();
		System.out.print("itrator输出      ");
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
		System.out.print("forech输出      ");
		for (String s : words) {
			System.out.print(s + "    ");
		}
		System.out.println(words.size());

	}
}