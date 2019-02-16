/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devonmusa.util.sort;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/17 02:25
 */
public class OneMillionsIntNumberUsing1MSortTest {
    private OneMillionsIntNumberUsing1MSort using1mSort = new OneMillionsIntNumberUsing1MSort();
    private static String fileName = "1MillionsIntNumber.txt";
    private static String sortedFileName = "sortedIntNumber.txt";
    private static final String filePath = "src\\test\\java\\org\\devonmusa\\util\\sort";
    private static  String dir = System.getProperty("user.dir");
    @Before
    public void setUp(){
        using1mSort.productIntNumberWriteFile(dir + File.separator + filePath + File.separator + fileName);
    }

    @Test
    public void oneMllionIntNumberUseLeastMemorySort() {

        Long startTime = System.currentTimeMillis();
        Byte[] bytes = using1mSort.OneMllionIntNumberUseLeastMemorySort(dir + File.separator + filePath + File.separator + fileName);
        using1mSort.writeSortedNumberIntoFile(bytes, dir + File.separator + filePath + File.separator + sortedFileName);
        Long endTime = System.currentTimeMillis();
        System.out.println("Used time:" + (endTime - startTime));
    }


}