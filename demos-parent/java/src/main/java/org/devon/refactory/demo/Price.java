package org.devon.refactory.demo;
abstract class Price {
	int getFrequentRenterPoints(int daysRented){
		if((getPriceCode()==Movie.NEW_RELEASE) && daysRented>1){
			return 2;
		}else{
			return 1;
		}
	}
	double getCharge(int daysRented) {
		double result = 0;
		switch (getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2) 
					result += (daysRented - 2) * 1.5;
					break;
					
			case Movie.NEW_RELEASE:
				
				result += daysRented*3;
				break;
			
			case Movie.CHILDRENS:
				result +=1.5;
				 if(daysRented>3)
					 result += (daysRented-3)*1.5;
				break;
		}
		return result;
	}
	
	public double getCharge(Movie _movie,int daysRented){
		return 0;
		
	}
//	abstract class Price  {
//		abstract int getPriceCode();	
//	}
//	class ChildrensPrice extends Price {
//		int getPriceCode() {
//			return Movie.CHILDRENS;
//		}
//		abstract double getCharge(int daysRented) {
//			 double result = 1.5;
//			 if(daysRented>3)
//				 result += (daysRented-3)*1.5;
//			return result;
//		}
//	}
	
//	class NewReleasePrice extends Price {
//		int getPriceCode() {
//			return Movie.NEW_RELEASE;
//		}
//		abstract double getCharge(int daysRented) {	
//			return daysRented*1.5;
//		}
//	}
	
//	class RegularPrice extends Price {
//		int getPriceCode(){
//			return Movie.REGULAR;
//		}
//		double getCharge(int daysRented) {
//			double result = 2;
//			if (daysRented > 2) 
//				result += (daysRented - 2) * 1.5;
//				return result;
//		}
//	}

	public int getPriceCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}


