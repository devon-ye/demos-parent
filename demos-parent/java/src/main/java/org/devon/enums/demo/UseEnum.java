package org.devon.enums.demo;


public class UseEnum {

	public static void main(String[] args) {
		UseEnum useEnum = new UseEnum();
		useEnum.enumVlalusePrint();
	}

	public void enumVlalusePrint() {
		for (Spiciness e : Spiciness.values()) {
			System.out.println(e);
			System.err.println(e.ordinal());
		}
	}

	public enum Spiciness {
		NOT, MILD, HOT, MEDIUM, FLAMING
	}
}
