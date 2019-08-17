package org.devon.design.pattern.description.instances;
/**
*
*@author Devonmusa
*@date   2017年8月8日
*/
public class Decorator extends AbstractDrink{
	private AbstractDrink dirnk;
	private float price;
/*	private String description;*/
	
	
	
	
	
	public Decorator(AbstractDrink dirnk) {
		this.dirnk = dirnk;
	}

	@Override
	public float getPrice() {
		return price +dirnk.getPrice(); 
	}
	@Override
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String getDescription() {
		return super.getDescription() +"-" +super.getPrice() + "##"+ dirnk.getDescription();
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public float coast() {
		
		return super.getPrice() + dirnk.coast();
	}
	
	
	
	
}
