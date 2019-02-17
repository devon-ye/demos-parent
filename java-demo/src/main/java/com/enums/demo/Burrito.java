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
			break;
		case MILD:
			break;
		case MEDIU:
			System.out.println("a little hot.");
			break;
		case HOT:
			break;
		case FLAMING:
			break;
		default:
			System.out.println("maybe too hot.");
            break;
		}
	}

}
