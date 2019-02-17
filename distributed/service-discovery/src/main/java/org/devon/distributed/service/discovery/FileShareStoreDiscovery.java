package org.devon.distributed.service.discovery;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author dewen.ye
 * @date 2019/1/24 00:19
 */
//TODO
public class FileShareStoreDiscovery implements ServiceDiscovery, Runnable {

    private static final String DEFAULT_CLUSTER = "default_cluster";
    private static final String SERVICE_DISCOVERY = "file/discovery/";

    private String clusterName;

    public FileShareStoreDiscovery(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    public void run() {

    }

    private String getContent() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            InetAddress inet4Address = Inet4Address.getLocalHost();
            InetAddress inet6Address = Inet6Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
