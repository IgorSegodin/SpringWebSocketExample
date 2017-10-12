package org.isegodin.example.spring.web.socket.config;

import org.isegodin.example.spring.web.socket.config.socket.HandshakeHandler;
import org.isegodin.example.spring.web.socket.config.socket.HttpHandshakeInterceptor;
import org.isegodin.example.spring.web.socket.config.socket.TopicSubscriptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Autowired
    private HandshakeHandler handshakeHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/channel");
        config.setApplicationDestinationPrefixes("/inbound");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket")
                .setHandshakeHandler(handshakeHandler)
                .addInterceptors(new HttpHandshakeInterceptor())
                .withSockJS();
    }

    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(new TopicSubscriptionInterceptor());
    }

}