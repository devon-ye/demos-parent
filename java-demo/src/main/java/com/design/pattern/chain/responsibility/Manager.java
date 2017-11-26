package com.design.pattern.chain.responsibility;

/**
 * @Describetion
 * @author Devonmusa
 * @date 2017年3月1日
 */
public class Manager extends Handler {

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.5) {
			succesor.processDiscount(discount);
		} else {
			System.out.format(this.getClass().getSimpleName() + " 批准了 :%.4f%n", discount);
		}

	}

}
