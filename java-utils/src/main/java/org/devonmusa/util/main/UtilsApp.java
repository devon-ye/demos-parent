package org.devonmusa.util.main;

import org.devonmusa.util.config.load.LogConfigLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.pattern.Util;

/**
 * Hello world!
 *
 */
public class UtilsApp 
{   private static Logger logger=LoggerFactory.getLogger(Util.class);
    public static void main( String[] args )
    {
    	if(args.length<1){
    		System.out.println("Please input util  name:");
    	}
    	String name=args[0];
    	switch(name){
    	case  "Log":
    	     LogConfigLoadUtil.init("path");
    	     logger.info("###########################  Log Config Loaded Success  ########################");
    	     break;
    	case "Jdbc":
    		 //JdbcConnectUtil();
    	case "XMLParse":
    		 //XMLConfigParse();
    	case "NullBankCheck":
    		 // NullBankCheckUtil();
    	case "IPv4":
    		  //IPAddress4CheckUtil();
    	case "IPv6":
    		  //IPAddress6CheckUtil();
    	default :
    		  System.exit(0);
    	  
    	
    	}      
    }
}
