package org.devon.parallel.knnclassifier;

import java.util.concurrent.CountDownLatch;

/**
 * @author dewen.ye
 * @date 2019/3/10 08:59
 */
public class IndividualTask implements Runnable {
    private final Distance[] distances;
    private final int index;
    private final Sample localExample;
    private final Sample example;
    private final CountDownLatch countDownLatch;


    public IndividualTask(Distance[] distances, int index, Sample localExample, Sample example, CountDownLatch countDownLatch) {
        this.distances = distances;
        this.index = index;
        this.localExample = localExample;
        this.example = example;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
         distances[index] = new Distance();
         distances[index].setIndex(index);
         distances[index].setCalculator(EuclideanDistanceCalculator.calculate(localExample,example));
        countDownLatch.countDown();
    }
}
