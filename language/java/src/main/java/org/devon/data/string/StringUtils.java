package org.devon.data.string;


import org.apache.commons.lang3.time.DateFormatUtils;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Random;

public class StringUtils {

	private static String DATE_FORMAT = "yy-MM-dd HH:mm:ss";
	private static Random random = new Random();

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

	public static void main(String[] args) {
		String s1 = "uml";
		String s2 = "uml";
		String s3 = new String("uml");
		String s4 = new String("uml");
		printAddresses("s1:", s1);
		printAddresses("s2:", s2);
		printAddresses("s3:", s3);
		printAddresses("s4:", s4);

		if (s1 == s2) {
			System.out.println(true);
		}
		if (s3 == s4) {
			System.out.println(true);
		}
		if (s1.equals(s3)) {
			System.out.println(true);
		}
		float[] f[][] = new float[6][6][7];
		System.out.println(f);
		try {
			throw new RuntimeException();
			//System.out.println("error1");
		} catch (Exception e) {
			System.out.println("error2");
		}
		System.out.println("error3");
	}


	private static Unsafe getUnsafe() {
		try {
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			return (Unsafe) theUnsafe.get(null);
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	static final Unsafe unsafe = getUnsafe();
	static final boolean is64bit = true;

	public static void printAddresses(String label, Object... objects) {
		System.out.print(label + ": 0x");
		long last = 0;
		int offset = unsafe.arrayBaseOffset(objects.getClass());
		int scale = unsafe.arrayIndexScale(objects.getClass());
		switch (scale) {
			case 4:
				long factor = is64bit ? 8 : 1;
				final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
				System.out.print(Long.toHexString(i1));
				last = i1;
				for (int i = 1; i < objects.length; i++) {
					final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
					if (i2 > last)
						System.out.print(", +" + Long.toHexString(i2 - last));
					else
						System.out.print(", -" + Long.toHexString(last - i2));
					last = i2;
				}
				break;
			case 8:
				throw new AssertionError("Not supported");
		}
		System.out.println();
	}

}
