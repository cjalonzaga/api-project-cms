package com.project.api.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ResponseCookie cookie = ResponseCookie.from("authToken", "")
                                .httpOnly(true)
                                .secure(false) // or true in prod
                                .path("/")
                                .maxAge(0)
                                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
