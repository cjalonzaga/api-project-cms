package com.project.api.config.security;

import com.project.api.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetail implements UserDetails {

    private final User user;

    public CustomUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton( new SimpleGrantedAuthority( "ROLE_" +user.getUserRole().getName() ));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getValid();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getValid();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getValid();
    }

    @Override
    public boolean isEnabled() {
        return user.getValid();
    }




}
