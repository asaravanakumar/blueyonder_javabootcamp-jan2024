package com.blueyonder.bankingapp.controller;

import com.blueyonder.bankingapp.model.LoginRequest;
import com.blueyonder.bankingapp.model.LoginResponse;
import com.blueyonder.bankingapp.model.UserRequest;
import com.blueyonder.bankingapp.service.AuthService;
import com.blueyonder.bankingapp.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    CustomUserDetailsService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthService authService;

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

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        log.info("Login Request Received {}", request);

//        return LoginResponse.builder()
//                .token("Test Token")
//                .build();

        return authService.attemptLogin(request.getUsername(), request.getPassword());
    }
}
