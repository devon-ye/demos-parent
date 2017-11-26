package com.switchs.demo;

public class NumberTransformChineseNumber {
	public static void main(String[] args) {
		long value = 1731312312;
		moneyValueTransformChar(value);
	}

	public static void moneyValueTransformChar(long value) {
		String moneyValue_str = String.valueOf(value);

		char ch[] = moneyValue_str.toCharArray();

		for (char key : ch) {
			System.out.print(key + "\t");
		}
		System.out.println();
		charTransformNumber(ch);

	}

	public static void charTransformNumber(char[] ch) {
		String str = "";
		if (str != null){
			for (char key : ch) {
				String str_temp = numberTransformChineseNumber(key);
				str += str_temp;
			}
			System.out.println(str);
		}
	}

	public static String numberTransformChineseNumber(char ch) {
		String str = null;

		switch (ch) {
		case '1':
			str = "壹";
			return str;
		case '2':
			str = "贰";
			return str;
		case '3':
			str = "叁";
			return str;
		case '4':
			str = "肆";
			return str;
		case '5':
			str = "伍";
			return str;
		case '6':
			str = "陆";
			return str;
		case '7':
			str = "柒";
			return str;
		case '8':
			str = "捌";
			return str;
		case '9':
			str = "玖";
			return str;
		}
		return str;
	}

}
