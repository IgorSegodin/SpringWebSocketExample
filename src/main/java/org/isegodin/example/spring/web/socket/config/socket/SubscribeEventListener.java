package org.isegodin.example.spring.web.socket.config.socket;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.security.Principal;

/**
 * TODO right now disabled
 *
 * @author i.segodin
 */
//@Component
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {

    @Override
    public void onApplicationEvent(SessionSubscribeEvent event) {
        String topic = String.valueOf(event.getMessage().getHeaders().get("simpDestination"));
        StompHeaderAccessor wrap = StompHeaderAccessor.wrap(event.getMessage());
        wrap.getSessionAttributes().get("sessionId");
        Principal user = event.getUser();
    }
}
