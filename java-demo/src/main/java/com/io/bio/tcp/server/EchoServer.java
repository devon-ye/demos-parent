package com.io.bio.tcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/12/2.
 */
public class EchoServer {


    private void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                socket = serverSocket.accept();
                //实例化客户端得输入流
                InputStream inputStream = socket.getInputStream();
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
            if (socket != null) {
                try {
                    socket.close();
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
