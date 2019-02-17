/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.io.channel;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/16 20:22
 */
public class FileChannelDemoTest {

    @Test
    public void memoryMaped() {
        FileChannelDemo fileChannelDemo = new FileChannelDemo();
        fileChannelDemo.memoryMaped();
    }
}