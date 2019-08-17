package org.devon.parallel.knnclassifier;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author dewen.ye
 * @date 2019/3/11 23:42
 */
public class GroupDistanceTask implements Runnable {

    private final Distance[] distances;
    private final int startIndex, endIndex;
    private final Sample example;
    private final List<? extends Sample> dataList;
    private final CountDownLatch countDownLatch;


    public GroupDistanceTask(Distance[] distances, int startIndex, int endIndex, Sample example, List<? extends Sample> dataList, CountDownLatch countDownLatch) {
        this.distances = distances;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.example = example;
        this.dataList = dataList;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            Sample localSample = dataList.get(i);
            distances[i] = new Distance();
            distances[i].setIndex(i);
            distances[i].setCalculator(EuclideanDistanceCalculator.calculate(localSample, example));
        }
        countDownLatch.countDown();

    }
}
