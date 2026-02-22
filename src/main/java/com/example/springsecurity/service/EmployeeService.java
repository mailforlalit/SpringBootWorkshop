package com.example.springsecurity.service;

import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
}
