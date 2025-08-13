package com.project.api.restHandlers;

import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import com.project.api.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("user/signup")
    public UserDto create(@RequestBody UserDto user){
        return  userService.create( user );
    }

    @GetMapping("user/getAll")
    public List<UserDto> getAll(){
        return userService.getAll();
    }
}
