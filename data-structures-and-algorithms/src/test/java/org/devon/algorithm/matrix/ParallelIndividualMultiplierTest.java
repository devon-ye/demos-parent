package org.devon.algorithm.matrix;

import org.junit.Test;



/**
 * @author dewen.ye
 * @date 2019/2/18 22:44
 */
public class ParallelIndividualMultiplierTest {

    @Test
    public void multiply() {
        MatrixGenerator<Double> matrixGenerator = new MatrixGenerator<>();
        Double[][] matrix1 = matrixGenerator.generate(200, 200, Double.class);
        Double[][] matrix2 = matrixGenerator.generate(200, 200, Double.class);

        ParallelIndividualMultiplier multiplier = new ParallelIndividualMultiplier();
        Double[][] result = new Double[400][400];
        long startTime = System.currentTimeMillis();
        System.out.println("starting...");
        multiplier.multiply(matrix1, matrix2, result);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:" +(endTime-startTime));
    }
}