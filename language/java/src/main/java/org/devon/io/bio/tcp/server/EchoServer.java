package org.devon.io.bio.tcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by lenovo on 2017/12/2.
 */
public class EchoServer {


    private void startServer() {
        ServerSocket serverSocket = null;
        ServerSocketChannel socketChannel = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8888);

            serverSocket.setSoTimeout(1000);

            while (serverSocket.isClosed()) {
                socket = serverSocket.accept();
                //实例化客户端得输入流
                inputStream = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                //实例化客户端得打印输出流
                PrintStream ps = new PrintStream(socket.getOutputStream());
                boolean flag = true;
                while (flag) {
                    String str = br.readLine();
                    if (str == null || "".equals(str)) {
                        flag = false;
                    } else {
                        if ("bye".equalsIgnoreCase(str)) {
                            flag = false;
                        } else {
                            ps.println("ECHO:" + str);
                        }
                    }

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        echoServer.startServer();
    }
}
