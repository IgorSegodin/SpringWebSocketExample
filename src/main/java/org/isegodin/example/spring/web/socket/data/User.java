package org.isegodin.example.spring.web.socket.data;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * @author isegodin
 */
public class User implements Principal {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
