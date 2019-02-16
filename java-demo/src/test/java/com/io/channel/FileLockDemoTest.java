/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.io.channel;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/16 20:20
 */
public class FileLockDemoTest {

    @Test
    public void lockDemo() {
        FileLockDemo fileLockDemo = new FileLockDemo();
        String userDir = System.getProperty("user.dir");
        String testFilePath = "src\\test\\java\\com\\io\\channel\\FileChannelTest.txt";
        String fileName = userDir + File.separator+ testFilePath;
        fileLockDemo.lockDemo(fileName);
    }
}