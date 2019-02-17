package org.devon.clazz.reflect;

public class ClassforNameDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			Class c = Class.forName(args[0]);
			Read read = (Read) c.newInstance();
			read.onlyRead();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Word implements Read {

	public void onlyRead() {
		System.out.println("This  is Word onlyRead method");

	}

}

class Excel implements Read {

	public void onlyRead() {
		System.out.println("This  is Excel onlyRead method");
	}

}

interface Read {
	void onlyRead();
}
