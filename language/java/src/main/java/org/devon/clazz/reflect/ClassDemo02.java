package org.devon.clazz.reflect;

public class ClassDemo02 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class c1 = int.class;
		Class c2 = String.class;
		Class c3 = Double.class;
		Class c4 = double.class;
		Class c5 = void.class;
		Class c6 = args.getClass();
		System.out.println("c1=" + c1 + "  c2=" + c2 + "  c3=" + c3 + "  c4=" + c4 + "  c5=" + c5 + "  c6=" + c6);

	}

}
