package org.isegodin.example.spring.web.socket.data;

/**
 * @author isegodin
 */
public class MessageRequest {

    private String text;
    private String channel;

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
}
