package com.log;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月16日 下午9:41:33
*
*/
public class LogZipTest {
	
	private static  Logger logger =  LoggerFactory.getLogger(LogZipTest.class);
	
	public static void init() throws Exception   {
		String LOG_CONFIG_PATH = System.getProperty("user.dir") +"/config/logback.xml";
//		LogConfigLoadUtil.logConfigLoad(LOG_CONFIG_PATH);
	}
	
	public static void testLogZip() throws InterruptedException {
		
		while(true){
			logger.info("this is logger info");
			Thread.sleep(1000 * 1);
			logger.error("this是 ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		testLogZip();
	}

}
