package org.devon.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dewen.ye
 * @date 2019/2/22 22:37
 */
public class ParallelIndividualMultiplier {


    public void multiply(Double[][] matrix1, Double[][] matrix2, Double[][] result) {

        List<Thread> threadList = new ArrayList<>();
        int rows1 = matrix1.length;
        int columns2 = matrix2[0].length;


        for (int i = 0; i < rows1; i++) {

            for (int j = 0; j < columns2; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                Thread thread = new Thread(task);
                thread.start();
                threadList.add(thread);

                if (threadList.size() % Runtime.getRuntime().availableProcessors() == 0) {
                    waitForThreadList(threadList);
                }
            }

        }

    }

    private void waitForThreadList(List<Thread> threadList) {
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threadList.clear();
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
