package org.devon.solution.load.balance;


import org.devon.solution.load.balance.request.Request;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author devon.ye
 * @datetime 2019/12/14 11:48 PM
 * @since
 */
public class RoundRobinLoadBalance implements LoadBalance{
	private Object lock = new Object();

	/**
	 * 当前client连接不同的server的计数器<serverName,Count>
	 */
	private final ConcurrentHashMap<String, AtomicInteger> allCounter = new ConcurrentHashMap<>();

	@Override
	public String name() {
		return RandomLoadBalance.class.getSimpleName();
	}

	@Override
	public <T> T select(List<T> invokers, Request request) {
		String serverUniqueName = request.serverUniqueName();
		AtomicInteger counter = allCounter.get(request.toString());
		if (counter == null) {
			counter = new AtomicInteger(0);
			allCounter.put(serverUniqueName, counter);
		}

		int currentCursor = counter.incrementAndGet();
		if (currentCursor > (Integer.MAX_VALUE - 100000)) { // 防止高并发下，溢出Integer.MAX_VALUE
			currentCursor = 0;
			allCounter.put(serverUniqueName, new AtomicInteger(0));
		}

		if (invokers.size() == 1) {
			return invokers.get(0);
		}

		int index = currentCursor % invokers.size();

		return invokers.get(index);
	}
}
