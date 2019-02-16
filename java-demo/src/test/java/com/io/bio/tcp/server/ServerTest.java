/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.io.bio.tcp.server;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/16 20:29
 */
public class ServerTest {

    @Test
    public void serverSocket() {
        Server server = new Server();
        server.serverSocket("127.0.0.1", 9999);
    }
}