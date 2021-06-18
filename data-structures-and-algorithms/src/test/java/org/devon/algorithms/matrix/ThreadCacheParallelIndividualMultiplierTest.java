package org.devon.algorithms.matrix;

import org.junit.Test;


/**
 * @author dewen.ye
 * @date 2019/2/18 23:29
 */
public class ThreadCacheParallelIndividualMultiplierTest {

    @Test
    public void multiply() {

        MatrixGenerator<Double> matrixGenerator = new MatrixGenerator<>();
        Double[][] matrix1 = matrixGenerator.generate(200, 200, Double.class);
        Double[][] matrix2 = matrixGenerator.generate(200, 200, Double.class);

        ThreadCacheParallelIndividualMultiplier multiplier = new ThreadCacheParallelIndividualMultiplier();
        Double[][] result = new Double[400][400];
        long startTime = System.currentTimeMillis();
        System.out.println("starting...");
        multiplier.multiply(matrix1, matrix2, result);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:" +(endTime-startTime));
    }
}