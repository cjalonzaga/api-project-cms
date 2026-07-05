package com.project.api.entities.mappers;

import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper extends AbstractMapper<UserDto , User> {

    protected UserMapper(ModelMapper modelMapper) {
        super(modelMapper , UserDto.class , User.class);
        modelMapper.addMappings(skipProperty);
    }

    PropertyMap<User , UserDto> skipProperty = new PropertyMap<User , UserDto>() {
        protected void configure() {
            skip().setPassword(null);
        }
    };


}
