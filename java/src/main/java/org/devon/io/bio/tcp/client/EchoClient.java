package org.devon.io.bio.tcp.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by lenovo on 2017/12/2.
 */
public class EchoClient {
    private static final Logger LOG = LoggerFactory.getLogger(EchoClient.class);

    public void client() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);
            socket.setSoTimeout(1000);
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean falg = true;
            while (falg) {
                System.out.println("输入信息：");
                String brStr = input.readLine();
                printStream.println(brStr);
                if ("bye".equalsIgnoreCase(brStr)) {
                    falg = false;
                } else {
                    String echo = bufferedReader.readLine();
                    System.out.println(echo);
                }
            }
        } catch (IOException e) {
            LOG.error("IOException:", e);
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
}
