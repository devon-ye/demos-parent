package org.devon.data.stracture.array;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * @author Devonmusa
 * @date 2019/8/18 10:59
 * @since
 */
public class ArrayPerformance {

    @Benchmark
    public void indexCopy(){
        int[]  intArray = new int[]{12,123,123,123,123214,2412,3123,12312,321,31,3123};
        int[] ints =new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            ints[i] = intArray[i];
        }
        intArray[0] = 0;
        ints[3] = 3;

    }

    @Benchmark
    public void nativeCopy(){
        int[]  intArray = new int[]{12,123,123,123,123214,2412,3123,12312,321,31,3123};
        int[] ints =new int[intArray.length];
        System.arraycopy(intArray,0,ints,0,ints.length);
        intArray[0] = 0;
        ints[3] = 3;
    }

    public static void main(String[] args) {
        ArrayPerformance performance = new ArrayPerformance();
        performance.indexCopy();
        performance.nativeCopy();
    }
}
