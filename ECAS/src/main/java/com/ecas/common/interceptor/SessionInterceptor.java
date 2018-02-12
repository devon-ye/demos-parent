package com.ecas.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/12/10.
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(SessionInterceptor.class);
    private static final String errorPage = "/index.do";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.debug("preHandle,start");
        System.out.println("selectUserByID");
        Login login = (Login) httpServletRequest.getSession().getAttribute("login");
        if (null == login) {
            log.debug("此用户未登录,禁止访问此URL.");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + errorPage);
            return false;// 如果返回false，则不再调用之后的方法
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.debug("postHandle,start");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.debug("afterCompletion,start");
    }
}
