package com.example.springsecurity.model;

public class LoginResponseDTO {
    private user u;
    private String jwt;

    public LoginResponseDTO(){

    }

    public LoginResponseDTO(user u, String jwt) {
        this.u = u;
        this.jwt = jwt;
    }

    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
