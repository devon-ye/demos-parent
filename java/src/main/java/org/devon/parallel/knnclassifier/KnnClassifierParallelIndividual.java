package org.devon.parallel.knnclassifier;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dewen.ye
 * @date 2019/3/10 08:54
 */
public class KnnClassifierParallelIndividual {
    private final List<? extends Sample> dataSet;
    private final int k;
     private final Sample  example;
    private final ThreadPoolExecutor executor;
    private final int numThreads;
    private final boolean isParallelSort;

    public KnnClassifierParallelIndividual(List<? extends Sample> dataSet, int k, Sample example, int factor, boolean isParallelSort) {
        this.dataSet = dataSet;
        this.k = k;
        this.example = example;
        this.numThreads = factor * (Runtime.getRuntime().availableProcessors());
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
        this.isParallelSort = isParallelSort;
    }

    public void classify(Sample sample) throws InterruptedException {
        Distance[] distances = new Distance[dataSet.size()];
        CountDownLatch countDownLatch = new CountDownLatch(dataSet.size());
        int index = 0;
        for (Sample localSample : dataSet) {
            IndividualTask task = new IndividualTask(distances, index, localSample, sample, countDownLatch);
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
