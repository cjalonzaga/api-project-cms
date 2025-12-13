package com.project.api.config.security;

import com.project.api.entities.User;
import com.project.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = null;

        if(userRepository.isUserExist(username))
            appUser = userRepository.findByUsername(username);

        if (appUser == null )
            throw new UsernameNotFoundException("User not found!");

        return new CustomUserDetail(appUser);
    }
}
