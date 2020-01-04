package org.devon.solution.rate.limiter;




/**
 * @author dewen.ye
 * @datetime 2019/12/7 10:18 AM
 * @since
 */
public class TokenBucketRateLimiter implements RateLimite {

	private final long  maxBucketSize;
	private final long refilleRate;

    private volatile double currentBucketSize;

    private double lastRefillTimestamp;

	public TokenBucketRateLimiter(long maxBucketSize, long refilleRate) {
		this.maxBucketSize = maxBucketSize;
		this.refilleRate = refilleRate;
		this.currentBucketSize = maxBucketSize;
		this.lastRefillTimestamp = System.nanoTime();
	}

	public synchronized boolean tryAcquireFailed(int tokens) {
         refill();
		if(currentBucketSize> tokens){
			currentBucketSize-= tokens;
			return true;
		}
		return false;
	}

	private void refill(){
     long now = System.nanoTime();
     double tokensAddTo = (now- lastRefillTimestamp)* refilleRate /1e9;
     currentBucketSize = Math.min(currentBucketSize+tokensAddTo,maxBucketSize);
     lastRefillTimestamp = now;
	}
}
