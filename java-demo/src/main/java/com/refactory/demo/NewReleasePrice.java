package com.refactory.demo;
/**
*@see
*@author  Devonmusa
*@date 2017年4月10日
*/
public  class NewReleasePrice extends Price {
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	public double getCharge(int daysRented) {	
		return daysRented*1.5;
	}
}
