package com.data.string.split;

public class NumberSplit {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "123-456-789-106";
		char delimiter = '-';
		numbersSplit(str, delimiter);
	}

	static public void numbersSplit(String str, char delimiter) {
		// 将字符串转换成字符数组
		char ch[] = str.toCharArray();

		// 计算分隔符数量,
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == delimiter) {
				count++;
			}
		}
		// 声明字符串数组
		String str1[] = new String[count + 1];
		// 用双层for循环对字符串数组赋值
		int m = 0;
		for (int i = 0; i < count + 1; i++) {
			for (int j = m; j < ch.length; j++) {
				if (ch[j] != delimiter) {
					// 将字符数组赋值给字符串数组
					if (str1[i] == null) {
						str1[i] = String.valueOf(ch[j]);
					} else {
						str1[i] += ch[j];
					}
				} else {
					m = j + 1;
					break;
				}

			}

		}
		// foreach遍历打印字符串数组
		for (String s : str1) {
			System.out.print(s + ",");
		}

	}
}
