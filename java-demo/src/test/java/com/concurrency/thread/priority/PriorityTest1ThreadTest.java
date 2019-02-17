/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.concurrency.thread.priority;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/17 02:07
 */
public class PriorityTest1ThreadTest {

    @Test
    public void test(){
        PriorityTest1Thread pt1t = new PriorityTest1Thread();
        pt1t.setPriority(10);
        pt1t.start();
        PriorityTest1Thread pt2t = new PriorityTest1Thread();
        pt2t.setPriority(1);
        pt2t.start();
    }

}