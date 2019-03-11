package org.devon.parallel.knnclassifier;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dewen.ye
 * @date 2019/3/11 23:54
 */
public class KnnClassifierParallelGroup {

    private final List<? extends Sample> dataSet;
    private final int k;
    private final Sample  example;
    private final ThreadPoolExecutor executor;
    private final int numThreads;
    private final boolean isParallelSort;

    public KnnClassifierParallelGroup(List<? extends Sample> dataSet, int k, Sample example, ThreadPoolExecutor executor, int numThreads, boolean isParallelSort) {
        this.dataSet = dataSet;
        this.k = k;
        this.example = example;
        this.executor = executor;
        this.numThreads = Runtime.getRuntime().availableProcessors();
        this.isParallelSort = isParallelSort;
    }

    public void classify(Sample sample) throws InterruptedException {
        Distance[] distances = new Distance[dataSet.size()];
        CountDownLatch countDownLatch = new CountDownLatch(numThreads);
       int length = dataSet.size()/numThreads;
       int startIndex = 0;
       int endIndex = length;
        for (int i = 0; i<numThreads;i++) {
            GroupDistanceTask task = new GroupDistanceTask(distances, startIndex, endIndex,dataSet, sample, countDownLatch);
            executor.execute(task);
            countDownLatch.await();
        }

        if (isParallelSort) {
            Arrays.parallelSort(distances);
        } else {
            Arrays.sort(distances);
        }
    }

}
