package com.design.pattern.chain.responsibility;

/**
 * @Describetion
 * @author Devonmusa
 * @date 2017年3月1日
 */
public class Ceo extends Handler {

	@Override
	public void processDiscount(float discount) {
		if (discount > 0.4) {
			System.out.format(this.getClass().getSimpleName() + " 批准了 :%.4f%n", discount);
		} else {
			System.out.println(this.getClass().getSimpleName() + " don't agreee " + discount);
		}

	}

}
