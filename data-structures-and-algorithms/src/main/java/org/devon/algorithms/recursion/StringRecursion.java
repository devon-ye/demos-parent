package org.devon.algorithms.recursion;

/**
 * @author devon.ye
 * @datetime 2020/3/24 11:30 上午
 * @since
 */
public class StringRecursion {


	public static void reverseString(char[] s) {
		helper(0, s);
	}

	private static void helper(int index, char [] str) {
		if (str == null || index >= str.length) {
			return;
		}
		helper(index + 1, str);
		System.out.print(str[index]);
	}

	public static void main(String[] args) {
		StringRecursion.reverseString(new char[]{'h','e','l','l','o'});
	}
}
