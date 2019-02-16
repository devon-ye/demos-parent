package com.io.aio.client;

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
*
*@author Devonmusa
*@date   2017年9月9日
*/
public class PortScan  extends Thread{
	private static Logger logger = LoggerFactory.getLogger(PortScan.class);
	private static  Set<Integer> freePortSet = new HashSet<>();
	private static Map<String,String>  map = new HashMap<>();
	private static final String hostIp_prx="192.168.1.";

	private   String hostIp="";
	public static void main(String[] args) {
		for(int i = 1; i < 30; i++) {
			String hostIpStr = hostIp_prx+i;
			new PortScan("Scan_Thread" + i,hostIpStr).start();
		}	

		for(int port :freePortSet) {
			logger.info("free port:" + port);
		}
	}
	
	public PortScan(String name,String hostIp) {
		setName(name);
		this.hostIp = hostIp;
	}
	
	public void  getHostInfo(String hostIp) {
		InetAddress inetAddress = null;
		try {
		inetAddress = InetAddress.getByName(this.hostIp);
		} catch (UnknownHostException e) {
			logger.error(" inetAddress UnknownHostException",e);

		}
		
		String hostName = null;
		if(inetAddress != null){
	      hostName = inetAddress.getHostName();
	      map.put(hostIp, hostName);
			logger.info("current Ip is " + this.hostIp + ", hostName:" + hostName);
		}
	}
	
	public   void  getFreePort() {
		InetAddress inetAddress = null;
		Socket socket  = null;
		try {
		
			inetAddress = InetAddress.getByName(hostIp);
			logger.info("hostName=" + inetAddress.getHostName() );
			for(int i=10000; i< 65536;i++) {
				try {
					 socket = new Socket(inetAddress,i);
				} catch (IOException e) {
					logger.error("current port:" + i + " had used! IOException:" ,e );
				}
				if(socket != null) {
					logger.info("current port:" + i + " is free !");
					freePortSet.add(i);
				}
			}
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void run() {
		getHostInfo(hostIp);
		
		getFreePort();
		
	}

}
