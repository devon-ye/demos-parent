package org.devonmusa.util.env;

import java.util.Properties;

/**
*
*@author  Devonmusa
*@date 2017年4月4日
*/
public class EnvironmentUtils {
	
	public static String getAppHome(){
		Properties props=System.getProperties();
		return props.getProperty("user.dir");
	}
}
