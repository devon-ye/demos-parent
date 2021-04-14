package org.devon.algorithms.leetcode;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/3/13 12:13 PM
 */
public class Matrix {


    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int colSize = matrix[0].length - 1;
        int rowIndex = 0;

        while (rowIndex < n) {
            int colLeft = 0;
            int colRight = colSize;
            //判断行开头元素是否大于 目标值，是直接返回false， 否则判断当前行内
            if (matrix[rowIndex][colLeft] > target) {
                return false;
            }
            //行内二分查找
            while (colLeft <= colRight) {
                int mid = (colLeft + colRight) / 2;
                if (matrix[rowIndex][mid] == target) {
                    return true;
                } else if (matrix[rowIndex][mid] > target) {
                    colRight = mid - 1;
                } else if (matrix[rowIndex][mid] < target) {
                    colLeft = mid + 1;
                }
            }
            rowIndex++;
        }
        return false;
    }


    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
