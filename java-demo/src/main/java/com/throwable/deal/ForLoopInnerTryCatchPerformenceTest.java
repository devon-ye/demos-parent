package com.throwable.deal;

import java.util.ArrayList;
import java.util.List;


/**
 * Describetion:
 *
 * @author Devonmusa
 * @version 2017年2月13日 下午11:45:09
 */
public class ForLoopInnerTryCatchPerformenceTest {
    private static long COUNT = Long.MAX_VALUE;


    public static void testForInner() {

        long startTimeMS = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            try {
                List <String> strings = new ArrayList <>();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTimeMS = System.nanoTime();  //4116481 3916802
        performancePrin(startTimeMS, endTimeMS);
    }

    public static void testForOutter() {
        long startTimeMS = System.nanoTime();
        try {
            for (int i = 0; i < COUNT; i++) {

                List <String> strings = new ArrayList <>();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTimeMS = System.nanoTime();
        performancePrin(startTimeMS, endTimeMS);
    }

    private static void performancePrin(long startTimeNS, long endTimeNS) {
        System.out.println("For loop outter try catch exception used time:" + (endTimeNS - startTimeNS));
    }

    public static void main(String[] args) {

        testForOutter();
        testForInner();
    }

}
