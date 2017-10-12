package org.isegodin.example.spring.web.socket.controller;

import org.isegodin.example.spring.web.socket.data.Message;
import org.isegodin.example.spring.web.socket.data.MessageRequest;
import org.isegodin.example.spring.web.socket.data.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author isegodin
 */
@MessageMapping("/message")
@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/send")
    public void greeting(MessageRequest message, Principal user) throws Exception {
        if (message.getChannel() == null || message.getChannel().isEmpty()) {
            throw new IllegalArgumentException("Specify destination channel for your message.");
        }

        // TODO save message to in-memory service
        Message msg = new Message(user.getName(), message.getText(), message.getChannel());

        template.convertAndSend("/channel/" + message.getChannel(), MessageResponse.fromMessage(msg));
    }

}
