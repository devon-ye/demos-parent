package org.devon.solution.load.balance;

import org.devon.solution.load.balance.request.Request;

import java.util.List;

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

	@Override
	public <T> T select(List<T> invokers, Request request) {
		return null;
	}
}
