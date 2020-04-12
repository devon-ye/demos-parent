package org.devon.solution.load.balance;


/**
 * @author devon.ye
 * @datetime 2019/12/14 11:48 PM
 * @since
 */
public class RoundRobinLoadBalance implements LoadBalance{
	private Object lock = new Object();
	@Override
	public String name() {
		return RandomLoadBalance.class.getSimpleName();
	}
}
