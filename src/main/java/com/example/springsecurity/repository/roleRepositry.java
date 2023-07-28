package com.example.springsecurity.repository;

import com.example.springsecurity.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepositry extends JpaRepository<role,Integer> {
    Optional<role> findByAuthority(String authority);
}
