package org.devon.framework.servlet;

/**
 * Created by lenovo on 2017/11/26.
 */

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ServletApp extends HttpServlet implements SingleThreadModel {
    private static final Logger LOG = LoggerFactory.getLogger(ServletApp.class);


    @Override
    public void init() {
        LOG.info("init method execute!");
        intiLog4j();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse rep) {
        LOG.info("doGet method execute!");
        req.getSession();
        req.getCookies();
        req.getContextPath();

        rep.setContentType("text/html");
        PrintWriter pw = null;
        try {
            pw = rep.getWriter();
            pw.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            pw.println("<HTML>");
            pw.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            pw.println("  <BODY>");
            pw.print("    This is ");
            pw.print(this.getClass());
            pw.println(", using the POST method");
            pw.println("  </BODY>");
            pw.println("</HTML>");
            pw.flush();
        } catch (IOException e) {
            LOG.error("doGet method is error, IOException:", e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse rep) {
        LOG.info("doPost method execute HttpServletRequest=" + req.toString());
    }

    private void intiLog4j() {
        String userDir = System.getProperty("user.dir");
        String log4jConfigFilePath = userDir + "/src/main/webapp/WEB-INF/log4j.xml";
        System.setProperty("user.home",userDir);
        System.out.println("initLog4j, log4jConfigFilePath=" + log4jConfigFilePath);
        try {
            File log4jConfigFile = new File(log4jConfigFilePath);
            if (log4jConfigFile.exists()) {
                Properties log4jProperties = new Properties();
                log4jProperties.load(new FileInputStream(log4jConfigFile));
                PropertyConfigurator.configure(log4jProperties);
                LOG.info("initLog4j finished");
            }
        } catch (IOException e) {
            LOG.error("initLog4j is failed! Exception:", e);
        }

    }


}
