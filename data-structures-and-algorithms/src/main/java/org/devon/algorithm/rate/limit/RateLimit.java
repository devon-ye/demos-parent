package org.devon.algorithm.rate.limit;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimit {
    private int size = 100;
    private int rate = 100;
    private int currentSize = 0;

    private AtomicInteger count;
    private int maxPerSecondVisit;

    private long now = System.currentTimeMillis();


    public boolean leakyBucket() {
        long currentTime = System.currentTimeMillis();
        currentSize = (int) Math.max(0, currentSize - (currentTime - now) * rate);
        if (currentSize < size) {
            now = currentTime;
            currentSize++;
            return true;
        } else {
            return false;
        }

    }

    public void tokenBucket() {

    }

    public void slideWindow() {

    }

    public void fixedWindow() {

    }

    public static void main(String[] args) {

    }
}
