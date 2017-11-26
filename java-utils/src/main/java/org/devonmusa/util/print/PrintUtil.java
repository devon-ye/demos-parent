package org.devonmusa.util.print;

import java.util.Properties;

public class PrintUtil {

	private PrintUtil() {
		throw new Error("PrintUtils class is forbiden instance!");
	}

	public static void printObj(Object obj) {
		System.out.println(obj.toString());
	}

	public static void print(String str) {
		System.out.println(str);
	}

	public static void newLine() {
		System.out.println();
	}

	public static void printError(String error) {
		System.err.println(error);
	}

	public static void printException(String excption) {
		System.err.println(excption);
	}

	public static void printlnSystemPropersies() {
		Properties props = System.getProperties();
		String propsStr = props.toString();
		String[] propStrArray = propsStr.split(",");
		for (String propStr : propStrArray) {
			System.out.println(propStr);
		}
	}

}
