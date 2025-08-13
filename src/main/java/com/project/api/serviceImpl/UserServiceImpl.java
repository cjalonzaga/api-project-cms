package com.project.api.serviceImpl;

import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import com.project.api.entities.mappers.UserMapper;
import com.project.api.enums.UserRole;
import com.project.api.repositories.UserRepository;
import com.project.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl extends UserMapper implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    UserServiceImpl(ModelMapper modelMapper , UserRepository userRepository,PasswordEncoder passwordEncoder){
        super(modelMapper);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(UserDto user) {

        if (userRepository.isUserExist(user.getUsername())){
            throw  new ResponseStatusException(HttpStatus.CONFLICT , "User with username " + user.getUsername() + " already exist! ");
        }
        User entity = toEntity(user);
        entity.setValid(true);
        entity.setPassword( passwordEncoder.encode( user.getPassword() ) );
        entity.setCreatedOn(LocalDateTime.now());
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setUserRole(UserRole.ADMIN);
        return toDto( userRepository.save(entity) );
    }

    @Override
    public List<UserDto> getAll() {
        return toDtoList(userRepository.findAll());
    }
}
