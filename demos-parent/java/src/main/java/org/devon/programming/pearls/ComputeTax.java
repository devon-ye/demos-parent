package org.devon.programming.pearls;

/**
*Describetion:
*@author  Devonmusa
*@date 2017年2月11日 上午11:33:06
*
*/
public class ComputeTax {
//	private double tax = 0;
	private double taxRate = 0.14;
	private double baseTax = 0;
	private static int taxRange[] = {2200,2700,3200,3700,4200,4700};
	
	public double computed(double income){
		
		for(int i = 0;i<taxRange.length;i++){
		
			
			if(income > taxRange[i]){
				taxRate += (i-1)/100;
				baseTax = taxRate * (income);
			}
			
			if(income<taxRange[0]){
				taxRate = 0;
				return income;
			}
		}	
		return baseTax;
	}
	
	public double computeBaseTax(double income){
		double baseTax = 0;
		for(int i = 0;;i++) {
			if(income<taxRange[i]){
				 break;
			}
//			if(taxRange[i]<income<taxRange[i+1]){
//				baseTax = 500 * taxRate
//			}
		}
		return baseTax;
	}

}
