package org.devon.io.nio.tcp.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 *
 * @author Devonmusa
 * @date 2017年8月13日
 */
public class TcpNonBlockServerDemo {

	private ServerSocketChannel serverSocketChannel;
	private Selector selector;
	private Charset charset = Charset.forName("UTF-8");

	public TcpNonBlockServerDemo() {

	}

	public void serverRegister() {

		try {
			selector = Selector.open();
			InetSocketAddress InetSocketAddress = new InetSocketAddress("127.0.0.1", 30000);
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			readWriteDataByChannel(selector,serverSocketChannel);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readWriteDataByChannel(Selector selector, ServerSocketChannel serverSocketChannel) {
		try {
			while (selector.select() > 0) {
				for (SelectionKey selectionKey : selector.selectedKeys()) {
					selector.selectedKeys().remove(selectionKey);
					if (selectionKey.isAcceptable()) {
						SocketChannel sc = serverSocketChannel.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
						selectionKey.interestOps(SelectionKey.OP_ACCEPT);

					}
					String content = "";
					// 如果有数据要读取的时候
					if (selectionKey.isReadable()) {
						content = readDataFromChannel(selectionKey);
					}

					if (content.length() > 0) {
						writeDataToChannel(content);
					}

				}

			}
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String readDataFromChannel(SelectionKey selectionKey) {

		SocketChannel sc = (SocketChannel) selectionKey.channel();
		ByteBuffer bb = ByteBuffer.allocate(1024);
		String tempContent = "";
		try {
			while (sc.read(bb) > 0) {
				bb.flip();
				tempContent += charset.decode(bb);
			}

			System.out.println("==========" + tempContent);
			selectionKey.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {
			selectionKey.channel();
			if (selectionKey.channel() != null) {
				try {
					selectionKey.channel().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return tempContent;

	}

	public void writeDataToChannel(String content) {
		// 遍历该selector里注册的所有SelectKey
		for (SelectionKey key : selector.keys()) {
			// 选取该key对应的Channel
			Channel targetChannel = key.channel();
			// 如果该channel是SocketChannel对象
			if (targetChannel instanceof SocketChannel) {
				// 将独到的内容写入该Channel中
				SocketChannel dest = (SocketChannel) targetChannel;
				try {
					dest.write(charset.encode(content));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TcpNonBlockServerDemo  tcpNonBlockServerDemo = new TcpNonBlockServerDemo();
		tcpNonBlockServerDemo.serverRegister();
	}
}
