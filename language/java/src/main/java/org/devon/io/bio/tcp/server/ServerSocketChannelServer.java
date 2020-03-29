package org.devon.io.bio.tcp.server;

import java.io.IOException;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.ServerSocketChannel;


/**
 * @author devon.ye
 * @datetime 2020/3/15 1:38 上午
 * @since
 */
public class ServerSocketChannelServer {

	private ServerSocketChannel socketChannel;
	private AsynchronousServerSocketChannel serverSocketChannel;

	public ServerSocketChannelServer() {

	}

	public void open() {
		try {
			socketChannel = ServerSocketChannel.open();
			socketChannel.configureBlocking(false);

					serverSocketChannel = AsynchronousServerSocketChannel.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
