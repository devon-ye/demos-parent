package com.enums.demo;

public class Burrito {
	Spiciness degree;

	public Burrito(Spiciness degree) {
		this.degree = degree;
	}

	public void describe() {

		System.out.print("This Burrito is ");

		switch (degree) {
		case NOT:
			System.out.println("not splicy at all");
		case MILD:
		case MEDIU:
			System.out.println("a little hot.");
			break;
		case HOT:
		case FLAMING:
		default:
			System.out.println("maybe too hot.");

		}
	}

	public static void main(String[] args) {

		Burrito plain = new Burrito(Spiciness.HOT);
		Burrito greeChile = new Burrito(Spiciness.MEDIU);
		Burrito jalapeno = new Burrito(Spiciness.HOT);
		plain.describe();
		greeChile.describe();
		jalapeno.describe();
	}

}
