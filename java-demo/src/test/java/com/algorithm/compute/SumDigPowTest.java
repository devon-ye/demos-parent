package com.algorithm.compute;

import java.util.List;

import org.junit.Test;

/**
*
*@author Devonmusa
*@date   2017年6月4日
*/
public class SumDigPowTest {

	@Test
	public void test() {
		List<Long> sumdig = SumDigPow.sumDigPow(1,5000);
		System.out.println(sumdig);
	}
}
