package com.labs.sboot.security.controller;

import com.labs.sboot.security.model.UserRequest;
import com.labs.sboot.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AuthController {

    @Autowired
    CustomUserDetailsService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        boolean status = service.registerUser(userRequest);
        return status ? "User Registration Successful!!!" : "User Registration Failed";
    }

    @GetMapping("/users")
    public Collection<UserRequest> getUsers() {
        return service.getUsers();
    }
}
