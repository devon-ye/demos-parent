package com.ecas.common.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/12/28.
 */
public class EcasSessionFactory implements SessionFactory {

    @Override
    public Session createSession(SessionContext sessionContext) {
        EcasSession session = new EcasSession();
        if(sessionContext!= null && sessionContext instanceof WebSessionContext) {
            WebSessionContext webSessionContext = (WebSessionContext) sessionContext;
            HttpServletRequest request = (HttpServletRequest) webSessionContext;
            session.setHost(request.getRemoteAddr());
            session.setUserAgent(request.getHeader("User-Agent"));
        }
        return session;
    }
}
