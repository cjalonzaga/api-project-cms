package com.project.api.services;

import com.project.api.entities.dtos.UserDto;
import com.project.api.enums.UserRole;
import com.project.api.utils.AuthRequest;
import com.project.api.utils.AuthResponse;
import org.hibernate.usertype.UserType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDto create(UserDto user);

    List<UserDto> getAll();

    UserDto update(UserDto user);

    UserRole[] getUserTypes();
}
