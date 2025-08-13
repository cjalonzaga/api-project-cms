package com.project.api.entities.mappers;

import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper extends AbstractMapper<UserDto , User> {

    protected UserMapper(ModelMapper modelMapper) {
        super(modelMapper);
        modelMapper.addMappings(skipProperty);
    }

    PropertyMap<User , UserDto> skipProperty = new PropertyMap<User , UserDto>() {
        protected void configure() {
            skip().setPassword(null);
        }
    };

    @Override
    public UserDto toDto(User entity) {
        return modelMapper.map(entity , UserDto.class);
    }

    @Override
    public User toEntity(UserDto dto) {
        return modelMapper.map(dto , User.class);
    }

    @Override
    public List<UserDto> toDtoList(List<User> entityList) {
        return entityList.stream().map( user ->
                modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<User> toEntityList(List<UserDto> dtoList) {
        return null;
    }

}
