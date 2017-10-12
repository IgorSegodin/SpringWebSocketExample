package org.isegodin.example.spring.web.socket.service;

import org.isegodin.example.spring.web.socket.data.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author isegodin
 */
@Component
public class UserSessionService {

    private final ConcurrentHashMap<String, User> userSessionMap = new ConcurrentHashMap<>();


    public void add(String sessionId, User user) {
        userSessionMap.put(sessionId, user);
    }

    public User get(String sessionId) {
        return userSessionMap.get(sessionId);
    }

    public void remove(String sessionId, User user) {
        userSessionMap.remove(sessionId, user);
    }
}
