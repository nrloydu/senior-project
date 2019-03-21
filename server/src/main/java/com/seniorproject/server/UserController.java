package com.seniorproject.server;

import com.seniorproject.dto.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User getUser() {
        return new User(456, "Cool Name", "555");
    }
}