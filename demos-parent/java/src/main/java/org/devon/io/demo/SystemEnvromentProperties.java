package org.devon.io.demo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;

/**
 * @author Devonmusa
 * @date 2017年1月17日
 */
public class SystemEnvromentProperties {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        printSystemProperties();
    }

    public static void printSystemProperties() {
        Properties props = System.getProperties();
        String str = props.toString();
//		str.replaceAll("{", " ");
//		str.replaceAll("}", " ");
        String[] propss = str.split(",");

        for (String s : propss) {
            System.out.println(s);
        }
        Socket socket = null;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(5666);

            socket.bind(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
