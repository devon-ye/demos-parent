package com.data.string.check;

public class IpCheckDemo {

	public static void main(String[] args) {
		String str = "192.255.255.222";
		IpCheckDemo.ipCheck(str);
	}

	public static void ipCheck(String str) {
		String s[] = str.split("\\.", 4);
		boolean b = false;
		int a[] = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			try {
				a[i] = Integer.parseInt(s[i]);
				if (a[i] != 0) {
					b = true;
					System.out.println("11111");
				} else {
					b = false;
					System.out.println("2222");
					break;
				}
				System.out.println("b2" + b);
			} catch (Exception e) {
				System.out.println("  此IP不合法1");
				e.printStackTrace();
				break;
			}

			if (a[i] > 0 && a[i] <= 255) {
				if (a[i] != 0) {
					b = true;

				} else {
					b = false;
					break;
				}
			} else {
				b = false;
				break;
			}
			System.out.println(b);
		}

		for (String ss : s) {
			System.out.print(ss + " ");
		}

		if (b) {

			System.out.println("   此IP合法");
		} else {
			System.out.println("  此IP不合法");
		}
	}

}
