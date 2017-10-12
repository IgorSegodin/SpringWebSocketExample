package org.isegodin.example.spring.web.socket.config.socket;

import org.isegodin.example.spring.web.socket.data.User;
import org.isegodin.example.spring.web.socket.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @author isegodin
 */
@Component
public class HandshakeHandler extends DefaultHandshakeHandler {

    @Autowired
    private UserSessionService userSessionService;

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        if (!attributes.containsKey("sessionId")) {
            throw new RuntimeException("No sessionId attribute");
        }

        User user = userSessionService.get(String.valueOf(attributes.get("sessionId")));
        if (user == null) {
            throw new RuntimeException("Not authenticated");
        }

        return user;
    }
}
