package org.isegodin.example.spring.web.socket.util;

import javax.servlet.http.Cookie;

/**
 * @author isegodin
 */
public class CookieUtil {

	public static final String SESSION_ID = "sessionId";

    public static String getJSessionId(Cookie[] cookies) {
    	if (cookies == null) {
    		return null;
	    }
        for (Cookie cookie : cookies) {
	        if (SESSION_ID.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
