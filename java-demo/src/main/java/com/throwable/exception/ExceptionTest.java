package com.throwable.exception;

public class ExceptionTest {
	public static void main(String[] args) {
		dataException();
	}

	public static void dataException() {
		// String data=null;
		// int data;
		String data[] = { "", "2", "3", null };
		int len = data.length;
		String dats[];

		try {
			for (int i = 0; i < len; i++) {
				String temp = data[i];
				if (temp == "" || temp == null) {
					// throw new NullPointerException("空指针异常");
					continue;
				}
				dats = data;
				System.err.println(dats[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
