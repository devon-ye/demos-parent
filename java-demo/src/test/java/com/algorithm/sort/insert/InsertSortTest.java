package com.algorithm.sort.insert;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Devonmusa
 * @date 2017年5月23日
 */
public class InsertSortTest {
	
	private static final  Logger log = LoggerFactory.getLogger(InsertSortTest.class);
	
	private final long NS_TO_SESCOD = 1000000 ;
	private int[] sortResult = null;
	private long start = 0;
	private long end = 0;
	private int sortBeforeArray[] = null;
	private int sortBeforeArraySize = 0;
	private Random random;
	

	@Before
	public void setUp() {
		sortBeforeArraySize = 50000;
		sortBeforeArray = new int[sortBeforeArraySize];
		random = new Random();
		for (int i = 0; i < sortBeforeArraySize; i++) {
			sortBeforeArray[i] = random.nextInt(sortBeforeArraySize);
		}

		System.out.print("sorting before array:");
		for (int value : sortBeforeArray) {
			System.out.print("\t" + value);
		}
		start = System.nanoTime();
	}

	@Test
	public void testDirectSort() {
		sortResult = DirectInsertSort.insertSort(sortBeforeArray);
	}

	@Test
	public void testSortStrategy() {
		sortResult = DirectInsertSort.insertSort(sortBeforeArray, "asc");
	}

	@After
	public void tearDown() {
		end = System.nanoTime();
		System.out.println();
		System.out.println("sorted used time=" + (end - start)/NS_TO_SESCOD );
		System.out.print("sorted after result:");
		for (int value : sortResult) {
			System.out.print("\t" + value);
		}
	}
}
