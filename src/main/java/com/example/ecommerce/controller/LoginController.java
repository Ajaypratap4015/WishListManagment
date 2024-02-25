package com.example.ecommerce.controller;

import com.example.ecommerce.model.dto.LoginResponseDto;
import com.example.ecommerce.model.dto.SignUpResponseDto;
import com.example.ecommerce.model.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    // Endpoint for user registration
    @PostMapping("/register")
    public SignUpResponseDto registerUser(@RequestBody User user) {
        return userService.registerUser(user); // Call the userService to register a new user
    }

    // Endpoint for user login
    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody User user) {
        return userService.loginUser(user); // Call the userService to perform user login
    }
}
