package com.io.bio.udp.server;

import java.io.IOException;
import java.net.*;

/**
 * Created by lenovo on 2017/12/2.
 */
public class UDPServer {
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;

    public UDPServer() {
    }

    private void init() {
        try {
            datagramSocket = new DatagramSocket(3000);

        } catch (SocketException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendData() {
        String str = "hello word";
        try {
            datagramPacket = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("localhost"),9000);
            datagramSocket.send(datagramPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(datagramSocket!=null) {
                datagramSocket.close();
            }
        }


    }

    public static void main(String[] args) {
        UDPServer udpServer = new UDPServer();
        udpServer.init();
        udpServer.sendData();
    }
}
