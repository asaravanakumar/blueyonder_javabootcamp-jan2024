package com.labs.sboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Security!!!";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return "Hello!!!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to Admin console!!!";
    }


}
