package org.devon.io.aio.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Devonmusa
 * @date 2017年9月9日
 */
public class PortScan extends Thread {
    private static Logger LOG = LoggerFactory.getLogger(PortScan.class);
    private static Set<Integer> freePortSet = new HashSet<>();
    private static Map<String, String> map = new HashMap<>();

    private String hostIp = "";

    public static void main(String[] args) {



    }

    public PortScan(String name, String hostIp) {
        setName(name);
        this.hostIp = hostIp;
    }

    public void getHostInfo(String hostIp) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(this.hostIp);
        } catch (UnknownHostException e) {
            LOG.error(" inetAddress UnknownHostException", e);

        }

        String hostName = null;
        if (inetAddress != null) {
            hostName = inetAddress.getHostName();
            map.put(hostIp, hostName);
            LOG.info("current Ip is " + this.hostIp + ", hostName:" + hostName);
        }
    }

    public void getFreePort() {
        InetAddress inetAddress = null;
        Socket socket = null;
        try {
            inetAddress = InetAddress.getByName(hostIp);
            LOG.info("hostName=" + inetAddress.getHostName());
            for (int i = 10000; i < 65536; i++) {
                try {
                    socket = new Socket(inetAddress, i);
                    socket.setSoTimeout(1000);
                } catch (IOException e) {
                    LOG.error("current port:" + i + " had used! IOException:", e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            LOG.error("socket.close(),IOException:", e);
                        }
                    }
                }
                LOG.info("current port:" + i + " is free !");
                freePortSet.add(i);
            }
            this.printFreePort();
        } catch (UnknownHostException e) {
            LOG.error("UnknownHostException:", e);
        }
    }

    private void printFreePort(){
        for (int port : freePortSet) {
            System.out.println("free port:" + port);
            LOG.info("free port:" + port);
        }
    }

    @Override
    public void run() {
        getHostInfo(hostIp);
        getFreePort();
    }

}
