package org.devon.solution.load.balance;

/**
 * @author devon.ye
 * @datetime 2019/12/14 11:50 PM
 * @since
 */
public class WeightedLoadBalance implements LoadBalance{

	@Override
	public String name() {
		return RandomLoadBalance.class.getSimpleName();
	}
}
