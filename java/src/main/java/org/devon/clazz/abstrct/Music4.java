package org.devon.clazz.abstrct;

public class Music4 {

	static void tune(Instrument i) {
		i.play("10");
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void main(String[] args) {
		Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
		tuneAll(orchestra);
	}

}

abstract class Instrument {

	public abstract void play(String n);

	public String what() {
		return "Instrument";
	}

	public abstract void adjust();
}

class Wind extends Instrument {

	public void play(String n) {
		System.out.println("Wind.play() " + n);
	}

	public String what() {
		return "Wind";
	}

	public void adjust() {
	}

}

class Percussion extends Instrument {

	public void play(String n) {
		// TODO Auto-generated method stub
		System.out.println("Percussion.play() " + n);
	}

	public String what() {
		return "Percussion";
	}

	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Stringed extends Instrument {

	public void play(String n) {
		// TODO Auto-generated method stub
		System.out.println("Stringed.play() " + n);
	}

	public String what() {
		return "Stringed";
	}

	public void adjust() {

	}

}

class Brass extends Wind {

	public void play(String n) {
		System.out.println("Brass.play() " + n);
	}

	public void adjust() {

	}
}

class Woodwind extends Wind {

	public void play(String n) {
		System.out.println("Woodwind.play() " + n);
	}

	public String what() {
		return "Woodwind";
	}
}
