package org.devon.solution.rate.limiter.impl;


import org.devon.solution.rate.limiter.RateLimiter;

/**
 * @author dewen.ye
 * @datetime 2019/12/7 10:18 AM
 * @since
 */
public class TokenBucketRateLimiter implements RateLimiter {

	private final long maxBucketSize;
	private final long reFillRate;

	private volatile double currentBucketSize;

	private double lastRefillTimestamp;

	public TokenBucketRateLimiter(long maxBucketSize, long reFillRate) {
		this.maxBucketSize = maxBucketSize;
		this.reFillRate = reFillRate;
		this.currentBucketSize = maxBucketSize;
		this.lastRefillTimestamp = System.nanoTime();
	}

	public synchronized boolean tryAcquireFailed(int tokens) {
		refill();
		if (currentBucketSize > tokens) {
			currentBucketSize -= tokens;
			return true;
		}
		return false;
	}

	private void refill() {
		long now = System.nanoTime();
		double tokensAddTo = (now - lastRefillTimestamp) * reFillRate / 1e9;
		currentBucketSize = Math.min(currentBucketSize + tokensAddTo, maxBucketSize);
		lastRefillTimestamp = now;
	}
}
