package com.design.pattern.description.instances;
/**
*
*@author Devonmusa
*@date   2017年8月8日
*/
public class Decorator extends AbstractDrink{
	private AbstractDrink dirnk;
	private float price;
	private String description;
	
	
	
	
	
	public Decorator(AbstractDrink dirnk) {
		this.dirnk = dirnk;
	}
	
	public float getPrice() {
		return price +dirnk.getPrice(); 
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return super.getDescription() +"-" +super.getPrice() + "##"+ dirnk.getDescription();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public float coast() {
		
		return super.getPrice() + dirnk.coast();
	}
	
	
	
	
}
