package org.devon.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author devon.ye
 * @datetime 2020/3/15 4:28 下午
 * @since
 */
public class MatrixOp {


	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int columsNums = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] <= target && matrix[i][columsNums - 1] >= target) {
				return binarySearch(matrix[i], target);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] array, int tartget) {
		if (array == null) {
			return false;
		}
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			int mid = (startIndex + endIndex) / 2;
			if (tartget > array[mid]) {
				startIndex = mid + 1;
			} else if (tartget < array[mid]) {
				endIndex = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * 螺旋矩阵
	 *
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) return result;

		int colLeft = 0;
		int colRight = matrix[0].length - 1;
		int rowTop = 0;
		int rowBottom = matrix.length - 1;
		while (colLeft <= colRight && rowTop <= rowBottom) {

			for (int col = colLeft; col <= colRight; col++) {
				result.add(matrix[rowTop][col]);
			}

			for (int row = rowTop + 1; row <= rowBottom; row++) {
				result.add(matrix[row][colRight]);
			}

			if (rowTop < rowBottom && colLeft < colRight) {
				for (int col = colRight - 1; col > colLeft; col--) result.add(matrix[rowBottom][col]);
				for (int row = rowBottom; row > rowTop; row--) result.add(matrix[row][colLeft]);
			}
			rowTop++;
			rowBottom--;
			colLeft++;
			colRight--;
		}
		return result;

	}

	public static void main(String[] args) {
		MatrixOp.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

		MatrixOp.searchMatrix(new int[][]{{1}}, 1);
		MatrixOp.searchMatrix(new int[][]{{}}, 1);
	}
}
