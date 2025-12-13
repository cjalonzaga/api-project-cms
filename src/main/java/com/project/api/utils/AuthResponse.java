package com.project.api.utils;

import java.util.List;

public class AuthResponse {
    private String username;
    private List<String> roles;
    private String expiresIn;
    private Integer status;

    public AuthResponse(String username , List<String> roles , String expiresIn , Integer status) {
        this.username = username;
        this.roles = roles;
        this.expiresIn = expiresIn;
        this.status = status;
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

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

