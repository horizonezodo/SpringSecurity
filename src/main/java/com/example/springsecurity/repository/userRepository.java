package com.example.springsecurity.repository;

import com.example.springsecurity.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user,Integer> {
    Optional<user> findByUsername(String username);
}
