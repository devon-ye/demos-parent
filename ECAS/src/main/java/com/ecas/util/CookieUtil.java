package com.ecas.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/12/24.
 */
public class CookieUtil {

    public static String getCookie(String cookieName, HttpServletRequest request) throws NullPointerException{
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
}
