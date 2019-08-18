/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.io.aio.client;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/16 23:17
 */
public class PortScanTest {
    private static final String hostIp_prx = "192.168.1.";

    @Test
    public void getHostInfo() {
    }

    @Test
    public void getFreePort() {
        for (int i = 1; i < 30; i++) {
            String hostIpStr = hostIp_prx + i;
             new PortScan("Scan_Thread" + i, hostIpStr).start();
        }
    }
}