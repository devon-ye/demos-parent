package com.ecas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/12/24.
 */
public class CookieUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtil.class);

    public static String getCookie(String cookieName, HttpServletRequest request) throws NullPointerException{
        if(request == null) {
            LOGGER.error("request is null!");
        }
        Cookie[] cookies= request.getCookies();
        if(cookies == null || cookies.length == 0) {
            throw new NullPointerException("getCookies result is null");
        }
        for(Cookie cookie: cookies) {
            if(cookie.getName().equals(cookieName)) {
                return  cookie.getValue();
            }
        }
        return null;
    }

    public static void removeCookie(String cookieName) {

    }
}
