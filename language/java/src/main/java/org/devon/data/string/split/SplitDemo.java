package org.devon.data.string.split;

import java.util.Arrays;

public class SplitDemo {
	public final static String i = "Ihateyou!";

	public static void main(String[] args) {
		split("");
	}

	private static void split(String regex) {
		//char c;
		System.out.println(Arrays.toString(i.split(regex)));

		// String[] S = i.split(regex, i.length() - 1);

	}

}
