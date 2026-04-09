package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService service;

    // 🔐 LOGIN API
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        return service.login(username, password);
    }

    // 👑 ADMIN API
    @GetMapping("/admin/add")
    public String adminAccess() {
        return "Admin can add employee";
    }

    // 👤 EMPLOYEE API
    @GetMapping("/employee/profile")
    public String employeeAccess() {
        return "Employee profile data";
    }
}