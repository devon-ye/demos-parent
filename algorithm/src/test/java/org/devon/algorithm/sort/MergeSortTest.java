package org.devon.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Devonmusa
 * @date 2019/8/17 11:41
 * @since
 */
public class MergeSortTest {


    @Test
    public void mergeSort() {
        Double[] array = {123.0, 12312.1, 2.0, 232.9, 1312.0, 1.2332, 42.3};
        Double[] sortedArray = MergeSort.sort(array, 0, array.length - 1);
        for (int i = 1; i < sortedArray.length; i++) {
            Assert.assertTrue(sortedArray[i - 1] < sortedArray[i]);
        }

        Character[] characters = {'a', 'd', '=', '2', 'f', 'o', 's'};
        Character[] charactersSorted = MergeSort.sort(characters, 0, array.length - 1);
        for (int i = 1; i < sortedArray.length; i++) {
            Assert.assertTrue(charactersSorted[i - 1] < charactersSorted[i]);
        }

    }
}