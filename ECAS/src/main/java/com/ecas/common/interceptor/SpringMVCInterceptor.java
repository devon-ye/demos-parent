package com.ecas.common.interceptor;

import com.ecas.controller.AbstractBaseController;
import com.ecas.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/12/10.
 */
public class SpringMVCInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(SpringMVCInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("selectUserByID");
        AbstractBaseController abstractBaseController = (AbstractBaseController)handler ;
        abstractBaseController.setRequest(httpServletRequest);
        abstractBaseController.setResponse(httpServletResponse);
        abstractBaseController.setSession(httpServletRequest.getSession());
        abstractBaseController.setLogin((Login)httpServletRequest.getSession().getAttribute("login"));
        System.out.println("selectUserByID");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
