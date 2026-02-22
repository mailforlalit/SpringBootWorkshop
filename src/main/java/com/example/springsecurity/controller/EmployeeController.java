package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
@Autowired
EmployeeService employeeService;

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getEmployees() {
        System.out.println("In EmployeeController.getEmployees");
        return "List of Tech Amplifiers' Employees";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String home() {
        System.out.println("In EmployeeController.home");
        return "Welcome to the Home Page!";
    }

    @GetMapping("/employees/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getAllEmployees() {
        System.out.println("In EmployeeController.getAllEmployees");
        return service.getAllEmployees();
    }

}
