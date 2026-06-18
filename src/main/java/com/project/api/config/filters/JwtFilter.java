package com.project.api.config.filters;

import com.project.api.admin.controller.LoginController;
import com.project.api.config.security.CustomUserDetail;
import com.project.api.config.security.CustomUserDetailService;
import com.project.api.utils.JwtUtil;
import com.project.api.utils.WebUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("40 : JwtFilter");
        try{

            String jwtCooke = WebUtil.getCookie(request , "authToken");

            if(jwtCooke != null) {

                String authHeader = request.getHeader("Authorization");

                String username = jwtUtil.extractUsername(jwtCooke);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    CustomUserDetail userDetails = customUserDetailService.loadUserByUsername(username);
                    if (jwtUtil.validateToken(jwtCooke, userDetails)) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }
            }
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            filterChain.doFilter(request, response);

        }catch (Exception ex){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Token expired\"}");
            logger.info(ex.getMessage());
            logger.info("71: JWT FILTER: " + request.getRequestURI());

            /*TODO find a better way to handle expired token , maybe implement a refresh token*/
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
        boolean isRequestAllowed = request.getRequestURI().startsWith("/api/auth");
        String path = request.getServletPath();
        return  request.getRequestURI().startsWith("/api/auth") || request.getRequestURI().startsWith("/api/user/signup");
    }
}
