package org.devon.solution.rate.limiter;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dewen.ye
 * @datetime 2019/12/7 10:18 AM
 * @since
 */
public class TokenBucketRateLimiter {

	private AtomicLong bucket = new AtomicLong(0);


	public TokenBucketRateLimiter(){
		//ScheduledThreadPoolExecutor
	}


	private boolean tryAcquireFailed() {
		long l = bucket.longValue();
		while (l > 0) {
			if (bucket.compareAndSet(l, l - 1)) {
				return true;
			}
			l = bucket.longValue();
		}
		return false;
	}

}
