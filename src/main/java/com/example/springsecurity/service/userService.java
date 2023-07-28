package com.example.springsecurity.service;

import com.example.springsecurity.model.role;
import com.example.springsecurity.model.user;
import com.example.springsecurity.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class userService implements UserDetailsService {

    @Autowired
    public PasswordEncoder encoder;

    private final userRepository repo;

    public userService(userRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Can not find this name"));
    }
}
