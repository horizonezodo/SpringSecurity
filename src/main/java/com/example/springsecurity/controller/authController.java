package com.example.springsecurity.controller;

import com.example.springsecurity.model.LoginResponseDTO;
import com.example.springsecurity.model.user;
import com.example.springsecurity.model.userDTO;
import com.example.springsecurity.service.authenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class authController {
    private final authenticationService service;

    public authController(authenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public user registerUSer(@RequestBody userDTO u){
        return service.registerUser(u.getUsername(), u.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody userDTO user){
        return service.loginUser(user.getUsername(), user.getPassword());
    }
}
