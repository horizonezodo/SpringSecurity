package com.example.springsecurity.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name = "roles")
public class role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int reoleId;

    private String authority;

    public role() {
    }

    public role(String authority) {
        this.authority = authority;
    }

    public role(int reoleId, String authority) {
        this.reoleId = reoleId;
        this.authority = authority;
    }

    public int getReoleId() {
        return reoleId;
    }

    public void setReoleId(int reoleId) {
        this.reoleId = reoleId;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
