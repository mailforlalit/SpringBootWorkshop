package com.example.springsecurity.controller;

import com.example.springsecurity.dto.LoginDTO;
import com.example.springsecurity.dto.RegisterDTO;
import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JWTService jwtService;


    @PostMapping("/register")
    public Employee register(@RequestBody RegisterDTO registerDto) {
        System.out.println("In AuthController.register");
        Employee user = authService.register(registerDto);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDto) {
        System.out.println("In AuthController.login");
        Employee user = authService.authenticate(loginDto);
        String token = jwtService.generateToken(user);
        return token;
    }

}
