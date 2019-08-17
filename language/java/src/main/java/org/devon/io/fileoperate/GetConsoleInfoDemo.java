package org.devon.io.fileoperate;

import java.io.IOException;

public class GetConsoleInfoDemo {

	public static void main(String[] args) throws IOException {

		GetConsoleInfoDemo gt = new GetConsoleInfoDemo();
		gt.getInputInfo();
	}

	public String getInputInfo() throws IOException {
		System.out.println("请输入：");
		byte buffer[] = new byte[1024];
		int count = System.in.read(buffer);
		char ch[] = new char[count]; // 后两位结束标志位
		for (int i = 0; i < count; i++) {
			ch[i] = (char) buffer[i];
		}
		String str = new String(ch);
		System.out.println(str);
		return str;
	}

}
