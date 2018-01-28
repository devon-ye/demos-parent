package com.ecas.common.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/12/28.
 */
public class EcasSessionFactory implements SessionFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(EcasSessionFactory.class);

    @Override
    public Session createSession(SessionContext sessionContext) {

        EcasSession session = new EcasSession();
        try {


            if (sessionContext != null && sessionContext instanceof WebSessionContext) {
                WebSessionContext webSessionContext = (WebSessionContext) sessionContext;
             //   LOGGER.debug("----------->request:{}, ------------>response:{}", webSessionContext.getServletRequest(), webSessionContext.getServletResponse());

               if(webSessionContext != null && webSessionContext instanceof HttpServletRequest) {
                   HttpServletRequest request = (HttpServletRequest) webSessionContext;
                   session.setHost(request.getRemoteAddr());
                   session.setUserAgent(request.getHeader("User-Agent"));
               }else {
                   LOGGER.error("webSessionContext class name:{}",webSessionContext.getClass().getName());
               }
            }
         //   LOGGER.debug("createSession, session:{}", session);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Exception:",e);
        }
        return session;
    }
}
