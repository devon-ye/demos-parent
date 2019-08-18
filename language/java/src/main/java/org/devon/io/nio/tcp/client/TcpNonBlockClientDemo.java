package org.devon.io.nio.tcp.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
*
*@author Devonmusa
*@date   2017年8月13日
*/
public class TcpNonBlockClientDemo extends Thread{
	
	private SocketChannel socketChannel;
	private Selector selector;
	private Charset charset = Charset.forName("UTF-8");
	
	public void clientRegister() {
		try {
			selector = Selector.open();
			InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 30000);
			socketChannel = SocketChannel.open(inetSocketAddress);
			socketChannel.configureBlocking(false);
			
			//socketChannel.register(selector, ops)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
