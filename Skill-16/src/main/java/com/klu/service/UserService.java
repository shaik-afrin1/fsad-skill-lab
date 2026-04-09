package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.User;
import com.klu.repository.UserRepository;
import com.klu.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private JwtUtil jwtUtil = new JwtUtil();

    public String login(String username, String password) {

        User user = repo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return jwtUtil.generateToken(username);
        }

        return "Invalid Credentials";
    }
}