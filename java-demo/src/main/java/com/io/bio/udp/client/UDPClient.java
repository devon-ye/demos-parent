package com.io.bio.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by lenovo on 2017/12/2.
 */
public class UDPClient {
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;

    public UDPClient() {

    }

    private void  init() {
        byte[]  bytes= new byte[1024];
        datagramPacket = new DatagramPacket(bytes,1024);
        try {
            datagramSocket = new DatagramSocket(9000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void receiver() {
        System.out.println("等待接收数据：");
        try {
            datagramSocket.receive(datagramPacket);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("length" +datagramPacket.getLength());
            stringBuilder.append(",");
            stringBuilder.append("data" + datagramPacket.getData());
            stringBuilder.append(",");
            stringBuilder.append("SocketAddress" + datagramPacket.getSocketAddress());
            stringBuilder.append(",");
            stringBuilder.append("port" + datagramPacket.getPort());
         String datas = stringBuilder.toString();
            System.out.println(datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DatagramPacket getDatagramPacket() {
        return datagramPacket;
    }

    public void setDatagramPacket(DatagramPacket datagramPacket) {
        this.datagramPacket = datagramPacket;
    }

    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    public void setDatagramSocket(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }


    public static void main(String[] args) {
        UDPClient udpClient = new UDPClient();
        udpClient.init();
        udpClient.receiver();
    }
}
