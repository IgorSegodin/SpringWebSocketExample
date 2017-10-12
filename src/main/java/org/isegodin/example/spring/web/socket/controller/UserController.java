package org.isegodin.example.spring.web.socket.controller;

import org.isegodin.example.spring.web.socket.data.User;
import org.isegodin.example.spring.web.socket.service.UserSessionService;
import org.isegodin.example.spring.web.socket.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author isegodin
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserSessionService userSessionService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.PUT, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity authenticate(@RequestBody String name, HttpServletRequest request) {
        userSessionService.add(CookieUtil.getJSessionId(request.getCookies()), new User(name));
        return ResponseEntity.ok().build();
    }
}
