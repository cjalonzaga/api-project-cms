package com.project.api.restHandlers;

import com.project.api.config.security.CustomUserDetail;
import com.project.api.entities.User;
import com.project.api.entities.dtos.UserDto;
import com.project.api.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("user/auth/me")
    public ResponseEntity<?> authUser(@AuthenticationPrincipal CustomUserDetail user){
        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }

//    @PostMapping("/user/logout")
//    public ResponseEntity<?> signIn(HttpServletRequest request, HttpServletResponse response){
//        ResponseCookie cookie = ResponseCookie.from("authToken", null)
//                .httpOnly(true)
//                .secure(false)
//                .path("/")
//                .maxAge(0)
//                .build();
//         response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
//
//        return ResponseEntity.ok().build();
//    }
}
