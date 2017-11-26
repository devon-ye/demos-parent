package com.refactory.demo;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private Enumeration<?> rentals;
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();

	public Customer(String _name) {
		super();
		this._name = _name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	double totalAmount = 0;
	int frequentRenterPoints = 0;

	public String htmlStatement() {

		rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
			result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();

		}

		result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
		result += "Your earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();

		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}
