package com.project.api.serviceImpl;

import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import com.project.api.entities.mappers.Mapper;
import com.project.api.entities.mappers.UserMapper;
import com.project.api.enums.UserRole;
import com.project.api.repositories.UserRepository;
import com.project.api.services.UserService;
import org.hibernate.usertype.UserType;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractCrudeService<User , Long > implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, UserMapper mapper){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(UserDto user) {

        if (userRepository.isUserExist(user.getUsername())){
            throw  new ResponseStatusException(HttpStatus.CONFLICT , "User with username " + user.getUsername() + " already exist! ");
        }
        User entity = mapper.toEntity(user);
        entity.setValid(true);
        entity.setPassword( passwordEncoder.encode( user.getPassword() ) );
        entity.setCreatedOn(LocalDateTime.now());
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setUserRole(UserRole.ADMIN);
        return mapper.toDto( save(entity) );
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto update(UserDto user) {
        return null;
    }

    @Override
    public UserRole[] getUserTypes() {
        return UserRole.values();
    }

	@Override
	protected JpaRepository<User, Long> repository() {
		return userRepository;
	}
}
