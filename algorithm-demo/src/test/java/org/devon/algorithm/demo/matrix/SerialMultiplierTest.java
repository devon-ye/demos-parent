/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.demo.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:19
 */
public class SerialMultiplierTest {

    @Test
    public void multiplier() {
        System.out.println("cost time start....");

        System.out.println("matrix compute start build data...");
        MatrixGenerator<Double> generator = new MatrixGenerator<>();
        System.out.println("cost time start1....");
        Double[][] doubleArray1 = generator.generate(500, 100, Double.class);
        System.out.println("cost time start2....");
        Double[][] doubleArray2 = generator.generate(200, 300, Double.class);
        System.out.println("cost time start3....");

        System.out.println("matrix compute end  data...");
        SerialMultiplier<Double> serialMultiplier = new SerialMultiplier<>();
        long startTime = System.currentTimeMillis();
        serialMultiplier.multiplier(doubleArray1, doubleArray2);
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:" + (endTime - startTime));
    }
}