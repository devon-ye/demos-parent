package org.devon.io.bio.tcp.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by lenovo on 2017/12/2.
 */
public class EchoThread implements Runnable {

    private Socket socket;

    public EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintStream printStream = null;
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            printStream = new PrintStream(socket.getOutputStream());
            boolean flag = true;
            while (flag) {
                String str = bufferedReader.readLine();
                if (str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        printStream.println("ECHO:" + str);
                    }
                }
            }

        } catch (IOException e) {

        } finally {
            printStream.close();
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
