/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.io.channel;

import org.junit.Test;

import java.io.IOException;


/**
 * @author dewen.ye
 * @date 2019/2/16 20:11
 */
public class GetChannelTest {
    String fileName = "data.txt";
    String context = "some .........";
    GetChannel gc = new GetChannel();

    @Test
    public void writeFileByFileOutputStream() {
        gc.writeFileByFileOutputStream(fileName, context);
    }

    @Test
    public void writerFileByRandomAccessFile() {
        gc.writerFileByRandomAccessFile(fileName, "do some.........");
    }

    @Test
    public void readFileByFileInputStreamChannel() {
        gc.readFileByFileInputStreamChannel(fileName);
    }


}