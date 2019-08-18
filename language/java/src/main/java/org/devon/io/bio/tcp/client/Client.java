package org.devon.io.bio.tcp.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author Devonmusa
 * @date 2017年8月13日
 */
public class Client {
    private static final Logger LOG = LoggerFactory.getLogger(Client.class);
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
            socket.setSoTimeout(1000);
            pw = new PrintWriter(socket.getOutputStream());
            pw.write("this is client connect");
        } catch (UnknownHostException e) {
            LOG.error("UnknownHostException:", e);
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
        }

    }


}
