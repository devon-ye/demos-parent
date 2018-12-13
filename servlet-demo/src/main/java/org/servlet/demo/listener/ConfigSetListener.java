package org.servlet.demo.listener;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lenovo on 2017/11/26.
 */
public class ConfigSetListener implements ServletContextListener {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // intiLog4j();
    }

    private void intiLog4j() {
        String userDir = System.getProperty("user.dir");
        String log4jConfigFilePath = userDir + "/config/log";
        System.setProperty("user.home",userDir);
        System.out.println("initLog4j, log4jConfigFilePath=" + log4jConfigFilePath);
        try {
            File log4jConfigFile = new File(log4jConfigFilePath);
            if (log4jConfigFile.exists()) {
                Properties log4jProperties = new Properties();
                log4jProperties.loadFromXML(new FileInputStream(log4jConfigFile));
                PropertyConfigurator.configure(log4jProperties);
                log.info("initLog4j finished");
            }
        } catch (IOException e) {
            log.error("initLog4j is failed! Exception:", e);
        }

    }

}
