package org.isegodin.example.spring.web.socket.data;

import java.time.LocalDateTime;

/**
 * @author isegodin
 */
public class MessageResponse {

    private String author;
    private String text;
    private LocalDateTime date;

    public MessageResponse(String author, String text, LocalDateTime date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public MessageResponse() {
    }

    public static MessageResponse fromMessage(Message message) {
        return new MessageResponse(message.getAuthor(), message.getText(), message.getDate());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
