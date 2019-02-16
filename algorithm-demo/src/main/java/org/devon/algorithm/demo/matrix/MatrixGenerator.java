package org.devon.algorithm.demo.matrix;

import java.util.Objects;
import java.util.Random;

/**
 * @author dewen.ye
 * @date 2019/2/15 21:29
 */
public class MatrixGenerator<T> implements Comparable<T> {
    private static Random random = new Random();
    @Override
    public int compareTo(T o) {
        return this.compareTo(o);
    }

    public T[][] generate(int rows, int columns, Class<?> clazz) {
        Double[][] ret = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ret[i][j] =  (Double) this.makeRandomNumber(clazz, random);
            }
        }
        return (T[][]) ret;
    }

    private Object makeRandomNumber(Class<?> clazz, Random random) {

        switch (clazz.getName()) {
            case "java.lang.Integer":
                return random.nextInt();
            case "java.lang.Double":
                return random.nextDouble();
            case "java.lang.Float":
                return random.nextFloat();
            case "java.lang.Boolean":
                return random.nextBoolean();
            default:
                return 0;
        }

    }
}
