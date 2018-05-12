package com.alekseysamoylov.learn.security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alekseysamoylov.learn.security.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> get() {
        return Arrays.asList(new Employee("A", "B", "Description"));
    }
}
