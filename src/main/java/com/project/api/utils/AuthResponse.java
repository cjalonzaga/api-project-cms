package com.project.api.utils;

import java.util.List;

public class AuthResponse {
    private String token;
    private String username;
    private List<String> roles;
    private Long expiresIn;
    private Integer status;

    public AuthResponse(String token , String username , List<String> roles , Long expiresIn , Integer status) {
        this.token = token;
        this.username = username;
        this.roles = roles;
        this.expiresIn = expiresIn;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

