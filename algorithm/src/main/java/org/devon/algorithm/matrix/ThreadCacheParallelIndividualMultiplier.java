package org.devon.algorithm.matrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dewen.ye
 * @date 2019/2/23 23:17
 */
public class ThreadCacheParallelIndividualMultiplier {
    ExecutorService executorService = Executors.newCachedThreadPool();

    public void multiply(Double[][] matrix1, Double[][] matrix2, Double[][] result) {

        int rows1 = matrix1.length;
        int columns2 = matrix2[0].length;


        for (int i = 0; i < rows1; i++) {

            for (int j = 0; j < columns2; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                executorService.submit(task);
            }

        }

    }


    class IndividualMultiplierTask implements Runnable {
        private final Double[][] result;
        private final Double[][] matrix1;
        private final Double[][] matrix2;

        private final int rows;
        private final int columns;

        public IndividualMultiplierTask(Double[][] result, Double[][] matrix1, Double[][] matrix2, int rows, int columns) {
            this.result = result;
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.rows = rows;
            this.columns = columns;
        }

        @Override
        public void run() {
            result[rows][columns] = 0D;
            for (int i = 0, length = matrix1[rows].length; i < length; i++) {
                result[rows][columns] += matrix1[rows][i] * matrix2[i][columns];
            }
        }
    }


}
