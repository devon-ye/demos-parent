package com.design.pattern.adapter.object;

/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月22日 上午12:51:03
*
*/
public class OperationAdapter implements ScoreOperation {
	private QuickSort sortObj;
	private BinarySearch searchObj;
	public OperationAdapter() {
		 sortObj = new QuickSort();
		 searchObj = new BinarySearch();
	}
	
	@Override
	public int[] sort(int[] array) {
		return sortObj.quickSort(array); //调用适配者类QuickSort的排序方法
	}

	@Override
	public int search(int[] array, int key) {
		return searchObj.binarySearch(array,key); //调用适配者类BinarySearch的查找方法
	}

}
