package com.io.bio.tcp.client;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 *
 * @author Devonmusa
 * @date 2017年8月13日
 */
public class Client {

	private String host;
	private int port;

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void connect(String host, int port) {
		Socket socket = null;
		PrintWriter pw = null;
		try {
			socket = new Socket(host, port);
			pw = new PrintWriter(socket.getOutputStream());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {

			pw.write("this is client connect");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 9999);
		client.connect("127.0.0.1", 9999);
	}


	public void test() {
		Client client = new Client("127.0.0.1", 9999);
		client.connect("127.0.0.1", 9999);
	}

}
