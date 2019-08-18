package org.devon.design.pattern.description.instances;



/**
 *
 * @author Devonmusa
 * @date 2017年8月7日
 */
public abstract class AbstractDrink {

	public String description;

	private float price = 0f;

	public String getDescription() {
		return description +"-"+ this.getPrice();
	}

	public float getPrice() {
		return price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public abstract float coast();
	
	
}
