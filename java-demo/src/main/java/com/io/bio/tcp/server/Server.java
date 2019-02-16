package com.io.bio.tcp.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author Devonmusa
 * @date 2017年8月13日
 */
public class Server {
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);

    public Server() {
    }

    public void serverSocket(String host, int port) {
        ServerSocket serverScoket = null;
        Socket socket = null;
        PrintWriter pw = null;

        try {

            serverScoket = new ServerSocket(9999);
            serverScoket.setSoTimeout(1000);
            socket = serverScoket.accept();
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            while (socket.isClosed()) {
                // pw = new PrintWriter("this is server connect");
                System.out.println(br.readLine());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            LOG.error("IOException:", e);
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverScoket != null) {
                try {
                    serverScoket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
