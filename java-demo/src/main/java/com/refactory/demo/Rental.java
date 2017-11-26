package com.refactory.demo;

public class Rental {
	private Movie _movie;
	private int daysRented;
	private Price _price;

	public Rental(Movie _movie, int _dayRental) {
		super();
		this._movie = _movie;
		this.daysRented = _dayRental;
	}

	public Movie get_movie() {
		return _movie;
	}

	public void set_movie(Movie _movie) {
		this._movie = _movie;
	}

	public int get_dayRental() {
		return daysRented;
	}

	public void set_dayRental(int _dayRental) {
		this.daysRented = _dayRental;
	}
    double getCharge(){
    	return _price.getCharge(_movie, daysRented);
    }
	int getFrequentRenterPoints() {
		
		return _movie.getFrequentRenterPoints(daysRented);
		
	}
	
	

}
