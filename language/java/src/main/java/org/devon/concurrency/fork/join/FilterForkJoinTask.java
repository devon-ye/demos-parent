package org.devon.concurrency.fork.join;

import java.util.concurrent.RecursiveTask;

/**
 * Created by lenovo on 2017/10/15.
 */
public class FilterForkJoinTask extends RecursiveTask {

    private static final int THRESHOLD = 2;

    @Override
    protected Boolean compute() {
        //TODO
        return true;
    }
}
