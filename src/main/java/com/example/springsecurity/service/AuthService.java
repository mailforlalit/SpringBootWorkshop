package com.example.springsecurity.service;

import com.example.springsecurity.dto.LoginDTO;
import com.example.springsecurity.dto.RegisterDTO;
import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    public Employee register(RegisterDTO input) {
        Employee user = new Employee();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());
        return repo.save(user);
    }

    public Employee authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
        );
        return repo.findByEmail(input.getEmail());
    }

}
