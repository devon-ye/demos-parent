package org.devon.algorithm.demo.matrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dewen.ye
 * @date 2019/2/15 21:46
 */
public class SerialMultiplier<T extends Number> {
    private static Logger LOG = LoggerFactory.getLogger(SerialMultiplier.class);

    public T[][] multiplier(Double[][] matrix1, Double[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            return null;
        }

        int rows = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        Double[][] result = new Double[rows][columns2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns2; j++) {
                result[i][j] = 0D;
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return (T[][]) result;
    }


    public static void main(String[] args) {
        System.out.println("cost time start....");

        LOG.info("matrix compute start build data...");
        MatrixGenerator<Double> generator = new MatrixGenerator<>();
        System.out.println("cost time start1....");
        Double[][] doubleArray1 = generator.generate(1000, 100, Double.class);
        System.out.println("cost time start2....");
        Double[][] doubleArray2 = generator.generate(200, 3000, Double.class);
        System.out.println("cost time start3....");

        LOG.info("matrix compute end  data...");
        SerialMultiplier<Double> serialMultiplier = new SerialMultiplier<>();
        long startTime = System.currentTimeMillis();
        serialMultiplier.multiplier(doubleArray1, doubleArray2);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:" + (endTime - startTime));
    }


}
