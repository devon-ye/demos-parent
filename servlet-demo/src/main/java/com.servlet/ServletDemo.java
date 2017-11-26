package com.servlet;

/**
 * Created by lenovo on 2017/11/26.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo extends HttpServlet {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse rep) {
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
            log.error("doGet method is error, IOException:", e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse rep) {
        log.info("doPost method HttpServletRequest=" +req.toString());
    }


}
