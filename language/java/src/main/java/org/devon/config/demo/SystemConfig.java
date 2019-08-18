package org.devon.config.demo;



/*
*@author  Devonmusa
*@version
*2017年1月27日 上午8:52:19
*
*/
public class SystemConfig {
	
	
	public static void main(String[] args) {
		String  intstance_workspace = System.getProperty("intstance.workspace");
		System.setProperty("APP_HOME", intstance_workspace);
		System.out.println(System.getProperty("APP_HOME"));
		//File tmpFile =File(instance_workspace,"tmp");
	}
}
