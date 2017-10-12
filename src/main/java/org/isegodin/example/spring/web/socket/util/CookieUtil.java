package org.isegodin.example.spring.web.socket.util;

import javax.servlet.http.Cookie;

/**
 * @author isegodin
 */
public class CookieUtil {


    public static String getJSessionId(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if ("JSESSIONID".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
