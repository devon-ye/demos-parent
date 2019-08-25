package org.devon.algorithms.leetcode;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/17 22:06
 * @since 1.0.0
 */
public class L838GraphReverse {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return null;
        }

        for (int i = 0, h = A.length; i < h; i++) {
            int itCount = A[i].length / 2;
            int d = A[i].length;

            for (int j = 0; j < itCount; j++) {
                int temp = ~A[i][j];
                A[i][j] = ~A[i][d - 1 - j];
                A[i][d - 1 - j] = temp;

            }

            if(A[i].length / 2!=0){
                A[i][itCount] = ~A[i][itCount];
            }
        }

        return  A;
    }
}
