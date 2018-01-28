package com.ecas.common.interceptor;

import com.ecas.common.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class ControllerCostLogInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerCostLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadLocalUtil.putTime(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return;
        }
        long endTIme = System.currentTimeMillis();
        long startTime = ThreadLocalUtil.getTime();
        long costTime = endTIme-startTime;

        StringBuilder stringBuilder = new StringBuilder("\n --------Controller execute report -----------------------------------");
        stringBuilder.append("\n URL:").append(request.getRequestURL()).append(",Method:").append(request.getMethod());
        stringBuilder.append("\nController  : ").append(((HandlerMethod) handler).getBeanType().getName()).append(", Method : ").append(((HandlerMethod) handler).getMethod().getName());
        //stringBuilder.append("\nUser Info   : ").append(ThreadLocalKit.getCurrentUser() == null ? "" : JsonKit.toJson(ThreadLocalKit.getCurrentUser()));
        if (request.getMethod().equalsIgnoreCase("GET")) {
           // logMsg.append("\nQueryString : ").append(URLKit.decodeURLComponent(StringUtils.isBlank(request.getQueryString()) ? "" : request.getQueryString()));
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
           // logMsg.append("\nParameter   : ").append(JsonKit.toJson(request.getParameterMap()));
        }

      //  stringBuilder.append("\nResponse    : ").append(result == null ? StringUtils.EMPTY : JsonKit.toJson(result));
        stringBuilder.append("\nCost Time   : ").append(costTime).append(" ms");
        stringBuilder.append("\n--------------------------------------------------------------------------------------------");
        LOGGER.trace(stringBuilder.toString());
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

}
