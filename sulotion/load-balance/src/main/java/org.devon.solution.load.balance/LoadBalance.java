package org.devon.solution.load.balance;

import org.devon.solution.load.balance.request.Request;

import java.util.List;

/**
 * @author devon.ye
 * @datetime 2019/12/14 11:45 PM
 * @since
 */
public interface LoadBalance {


	<T> T select(List<T> invokers, Request request);

	default String name(){
		return this.getClass().getSimpleName();
	}
}

