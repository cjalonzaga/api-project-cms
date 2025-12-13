package com.project.api.restHandlers;

import com.project.api.config.AppConfigProperties;
import com.project.api.config.security.CustomUserDetail;
import com.project.api.utils.AuthRequest;
import com.project.api.utils.AuthResponse;
import com.project.api.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppConfigProperties appConfigProperties;

    @PostMapping("/auth")
    public ResponseEntity<?> signIn(@RequestBody AuthRequest authRequest , HttpServletResponse response){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            UserDetails user = (UserDetails) auth.getPrincipal();

            String token = jwtUtil.generateToken(user);

            ResponseCookie cookie = ResponseCookie.from(appConfigProperties.getCookie().getName(), token)
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .maxAge(appConfigProperties.getCookie().getExpiresIn())
                    //.sameSite(Rfc6265CookieProcessor.STRICT.toString())
                    .build();

            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

            Date date = new Date(System.currentTimeMillis() + appConfigProperties.getJwt().getExpiresIn());

            List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(user.getUsername() , roles, date.toString() , HttpStatus.OK.value()));
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Invalid login credentials.");
        }
    }
}
