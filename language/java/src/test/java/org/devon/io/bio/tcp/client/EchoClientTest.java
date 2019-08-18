/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.io.bio.tcp.client;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/16 20:38
 */
public class EchoClientTest {

    @Test
    public void client() {
        EchoClient echoClient = new EchoClient();
        echoClient.client();
    }
}