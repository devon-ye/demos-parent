package org.devonmusa.util.config.load;

import java.util.Properties;

/**
*
*@author Devonmusa
*@date   2017年5月28日
*/
public class EnvConfigUtil {
	
	public static void setCommmonEnv() {
		Properties props=System.getProperties();
		String workerSpace =  props.getProperty("user.dir");
		System.setProperty("log.home", workerSpace +"/log");
		System.setProperty("log.dir", workerSpace +"/log");
	}
}
