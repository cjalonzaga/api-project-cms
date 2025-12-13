package com.project.api.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class WebUtil {
    public static String getCookie( HttpServletRequest request , String key){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(key)){
                    return  cookie.getValue();
                }
            }
        }

        return null;
    }

    public static Cookie getCookieObject( HttpServletRequest request , String key){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(key)){
                    System.out.println(cookie.getName());
                    return  cookie;
                }
            }
        }

        return null;
    }
}
