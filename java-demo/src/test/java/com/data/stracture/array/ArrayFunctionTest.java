package com.data.stracture.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
*
*@author Devonmusa
*@date   2017年5月24日
*/
public class ArrayFunctionTest {
	
	static int[] array = {1,23213,213,32432,234234,2342,3423432,4234,234,23423,4,32423,4,234,234543654};
	List<Integer> numbers = new ArrayList<Integer>();
	@Before
	public void setUp() {
		
		for(int temp: array) {
			numbers.add(temp);
			
		}
		
		for(int temp: numbers) {
		
			System.out.print( "\t"+temp);
		}
	}
	
	@Test
	public void testSubList(){
		System.out.println();
		int fromIndex = 0;
		int listSize = numbers.size();
		while(fromIndex < listSize) {
			int toIndex = fromIndex + 4;
			if(toIndex > listSize) {
				toIndex = listSize;
			}
			List<Integer> subArray  = numbers.subList(fromIndex, toIndex);
			for(int temp: subArray) {
				System.out.println(temp);
			}
			fromIndex += 4;
			System.out.println("####################");
		}	
	}
}
