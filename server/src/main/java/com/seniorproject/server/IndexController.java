package com.seniorproject.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {
    
    @RequestMapping("/")
    public String index() {
        return "You are not supposed to see me! Giggle!";
    }   
}