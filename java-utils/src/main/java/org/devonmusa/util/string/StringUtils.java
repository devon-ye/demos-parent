package org.devonmusa.util.string;


import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateFormatUtils;

public class StringUtils {

	private static String DATE_FORMAT = "yy-MM-dd HH:mm:ss";

	private StringUtils() {
		throw new Error("StringUtil class is forbiden instance!");
	}

	public static String getCurrentTime() {
		String str = null;
		Date date = new Date();
		str = DateFormatUtils.format(date, DATE_FORMAT);
		return str;
	}

	public static boolean isCheckIPv4Address(String str) {
		String s[] = str.split("\\.", 4);
		int temp = 0;
		if (s.length != 4) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			temp = Integer.parseInt(s[i]);
			if (temp > 0 && temp <= 255) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isCheckIPv6Address(String str) {

		return true;
	}

	public static String buildRandPassword(int lenth) {
		String result = "";
		Random random = new Random();
		int count = 0;
		while (count != lenth) {
			int itmp = random.nextInt(123);
			if (itmp >= 48 && itmp <= 57 || itmp >= 65 && itmp <= 90 || itmp >= 97 && itmp <= 122) {
				char ctmp = (char) itmp;
				result += String.valueOf(ctmp);
			}
			count = result.length();
		}
		return result;
	}

}
