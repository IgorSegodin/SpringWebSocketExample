package org.isegodin.example.spring.web.socket.data;

import java.time.LocalDateTime;

/**
 * @author i.segodin
 */
public class Message {

    private String author;
    private String text;
    private String channel;
    private LocalDateTime date = LocalDateTime.now();

    public Message(String author, String text, String channel) {
        this.author = author;
        this.text = text;
        this.channel = channel;
    }

    public Message() {
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
