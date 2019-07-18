package org.devon.algorithm.recursive;

public class DynamicProgramming {

    /**
     * 矩阵连乘：动态规划，求解最优解
     */
    public static void MatrixChain(int[] p, int m[][], int s[][]) {
        if (p == null || m == null || s == null) {
            throw new RuntimeException("params error is null");
        }
        int n = p.length - 1;
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int r = 2; r <= n; r++) {
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r + 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DynamicProgramming.MatrixChain(null, null, null);
    }
}
