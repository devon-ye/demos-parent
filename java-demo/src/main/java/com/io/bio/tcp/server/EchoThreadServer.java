package com.io.bio.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/12/2.
 */
public class EchoThreadServer {

    private void startServer() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (serverSocket.isClosed()) {
                serverSocket.setSoTimeout(1000);
                Socket socket = serverSocket.accept();
                EchoThread echoThread = new EchoThread(socket);

                Thread thread = new Thread(echoThread);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        EchoThreadServer echoThreadServer = new EchoThreadServer();
        echoThreadServer.startServer();
    }

}
