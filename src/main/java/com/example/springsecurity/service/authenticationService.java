package com.example.springsecurity.service;

import com.example.springsecurity.model.LoginResponseDTO;
import com.example.springsecurity.model.role;
import com.example.springsecurity.model.user;
import com.example.springsecurity.repository.roleRepositry;
import com.example.springsecurity.repository.userRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class authenticationService {
    private final userRepository repo;

    private final roleRepositry roleRepo;

    private final PasswordEncoder encoder;

    private final AuthenticationManager manager;

    private final tokenService service;

    public authenticationService(userRepository repo, roleRepositry roleRepo, PasswordEncoder encoder, AuthenticationManager manager, tokenService service) {
        this.repo = repo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.manager = manager;
        this.service = service;
    }

    public user registerUser(String username, String password){
        String encodePassword = encoder.encode(password);
        role userRole = roleRepo.findByAuthority("USER").get();
        Set<role> authorities = new HashSet<>();
        authorities.add(userRole);
        return repo.save(new user(0, username, encodePassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String pass){

        try{
            Authentication auth = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,pass)
            );
            String token = service.generateJwt(auth);
            return new LoginResponseDTO(repo.findByUsername(username).get(),token);
        }catch (AuthenticationException e){
            return new LoginResponseDTO(null,"");
        }
    }
}
