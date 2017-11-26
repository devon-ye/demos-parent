package com.design.pattern.adapter.object;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月22日 上午12:46:11
*
*/
public interface ScoreOperation {
	
	int[] sort(int[] array);
	
	int search(int[] array, int key);
}
