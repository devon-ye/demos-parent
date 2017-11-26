package com.operator.demo;

public class ChangeValuesDemo {

	public static void main(String[] args) {
		ChangeValuesDemo changeValuesDemo = new ChangeValuesDemo();
		changeValuesDemo.ChangeValues();
	}

	public void ChangeValues() {
		int a = 20;
		int b = 30;
		char c = 'A';
		char d = 'D';
		String e = "asd";
		String f = "ssa";
		int inttemp;
		char chartemp;
		String strtemp;
		inttemp = a;
		a = b;
		b = inttemp;
		System.out.println("a=" + a + "   b=" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a=" + a + "   b=" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a=" + a + "   b=" + b);
		System.out.println("----------------------------------------------");
		chartemp = c;
		c = d;
		d = chartemp;
		System.out.println("c=" + c + "   d=" + d);
		c = (char) (c + d);
		d = (char) (c - d);
		c = (char) (c - d);
		System.out.println("c=" + c + "   d=" + d);
		c = (char) (c ^ d);
		d = (char) (c ^ d);
		c = (char) (c ^ d);
		System.out.println("c=" + c + "   d=" + d);
		System.out.println("----------------------------------------------");
		strtemp = e;
		e = f;
		f = strtemp;
		System.out.println("e=" + e + "   f=" + f);
		e = e + f;
		System.out.println("e=" + e + "   f=" + f);
		// f = "e" - "f";
		// e = String("e" -"f");
		// e=e^f;
	}

}
