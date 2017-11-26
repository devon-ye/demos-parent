package com.interfaces.demo;

public class Music5 {

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

interface Instrument {
	int VALUE = 5;

	void play(String n);

	void adjust();
}

class Wind implements Instrument {

	public void play(String n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	public void adjust() {
		System.out.println(this + ".adjust() ");
	}

}

class Percussion implements Instrument {

	public void play(String n) {
		// TODO Auto-generated method stub
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println(this + ".adjust() ");
	}

}

class Stringed implements Instrument {

	public void play(String n) {
		// TODO Auto-generated method stub
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

	public void adjust() {
		System.out.println(this + ".adjust() ");
	}

}

class Brass extends Wind {

	public void play(String n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Brass";
	}

	public void adjust() {
		System.out.println(this + ".adjust() ");
	}
}

class Woodwind extends Wind {

	public void play(String n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Woodwind";
	}
}
