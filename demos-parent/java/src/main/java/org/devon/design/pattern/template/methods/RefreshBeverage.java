package org.devon.design.pattern.template.methods;


/**
 * this is abstract base class ,have a algorithm frame for all subclass
 * 
 * 
 * @author Devonmusa
 * @date 2017年3月4日
 */
public abstract class RefreshBeverage {

	public final void prepareBeverrageTemplate() {

		boilWater();

		brew();

		pourInCup();

		if (isCustomerAddCondiments()) {
			addCondiments();
		}
	}

	private void boilWater() {
		System.out.println("倒入杯中");
	}

	private void pourInCup() {
		System.out.println("将饮料导入杯中");
	}

	/**
	 * @see hook method by Override subclass this method
	 * @return
	 */
	protected boolean isCustomerAddCondiments() {
		return true;
	}

	protected abstract void brew();

	protected abstract void addCondiments();

}
