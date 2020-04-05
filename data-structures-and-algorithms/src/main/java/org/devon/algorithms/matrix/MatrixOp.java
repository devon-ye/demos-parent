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

		int minCol = 0;
		int maxCol = matrix[0].length - 1;
		int minRow = 0;
		int maxRow = matrix.length - 1;
		while (minCol <= maxCol && minRow <= maxRow) {

			for (int col = minCol; col <= maxCol; col++) {
				result.add(matrix[minRow][col]);
			}

			for (int row = minRow + 1; row <= maxRow; row++) {
				result.add(matrix[row][maxCol]);
			}

			if (minRow < maxRow && minCol < maxCol) {
				for (int col = maxCol - 1; col > minCol; col--) result.add(matrix[maxRow][col]);
				for (int row = maxRow; row > minRow; row--) result.add(matrix[row][minCol]);
			}

			minRow++;
			maxRow--;
			minCol++;
			maxCol--;
		}

		return result;

	}


	private int maxCol = 0;
	private int minCol = -1;
	private int maxRow = 0;
	private int minRow = -1;

	public List<Integer> spiralOrderRecursive(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) return result;
		int i = 0, j = 0;
		maxRow = matrix.length;
		maxCol = matrix[0].length;

		right(matrix, i, j, result);
		return result;
	}

	private void right(int[][] matrix, int i, int j, List<Integer> result) {
		if (j >= maxCol || minCol==maxCol) return;

		result.add(matrix[i][j]);

		if (j < maxCol) {
			right(matrix, i, j + 1, result);
		}

		maxCol -= 1;

		down(matrix, i + 1, j, result);
	}

	private void down(int[][] matrix, int i, int j, List<Integer> result) {
		if (i >= maxRow || minRow==maxRow) return;

		result.add(matrix[i][j]);
		if (i < maxRow) {
			down(matrix, i + 1, j, result);
		}
		maxRow -= 1;
		left(matrix, i, j - 1, result);
	}

	private void left(int[][] matrix, int i, int j, List<Integer> result) {
		if (j <= minCol || minCol==maxCol) return;

		result.add(matrix[i][j]);
		if (j > minCol) {
			left(matrix, i, j - 1, result);
		}
		minCol += 1;
		up(matrix, i - 1, j, result);
	}

	private void up(int[][] matrix, int i, int j, List<Integer> result) {
		if (i <= minRow  || minCol==maxCol) return;
		result.add(matrix[i][j]);
		if (j > minCol) {
			up(matrix, i - 1, j, result);
		}
		minRow += 1;
		right(matrix, i, j + 1, result);
	}


	public static void main(String[] args) {
		MatrixOp result = new MatrixOp();

		result.spiralOrderRecursive(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		//MatrixOp.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

		MatrixOp.searchMatrix(new int[][]{{1}}, 1);
		MatrixOp.searchMatrix(new int[][]{{}}, 1);
	}
}
