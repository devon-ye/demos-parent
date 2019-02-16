package com.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/12/30.
 */
public class LoggerTest {
    private Logger LOG = LoggerFactory.getLogger(LoggerTest.class);
    private String a="eqwqw";
    private String b="beqdw";
    private int c=23;
    private int d=56;
    private long count = 10;

    @Test
    public void test() {

        long startTime1 = System.currentTimeMillis();
        for(int i = 0;i<count;i++){
            LOG.debug("debug={}{}",a,c);
        }
        long endTime1 = System.currentTimeMillis();


        long startTime2 = System.currentTimeMillis();
        for(int i = 0;i<count;i++){
            LOG.debug("debug="+b+d);
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("{} concat usedTime=" +(endTime1-startTime1));
        System.out.println("+  concat usedTime=" +(endTime2-startTime2));
    }
}
