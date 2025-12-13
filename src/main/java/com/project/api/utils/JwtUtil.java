package com.project.api.utils;

import com.project.api.config.AppConfigProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    private AppConfigProperties appConfigProperties;

    public String generateToken(UserDetails userDetails){

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(appConfigProperties.getJwt().getSecret()));
        System.out.println(userDetails.getAuthorities());
        return Jwts.builder().subject(userDetails.getUsername())
                .claim("roles" , userDetails.getAuthorities())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + appConfigProperties.getJwt().getExpiresIn())) //864_000_000
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(appConfigProperties.getJwt().getSecret()) );
        try{
            return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean validateToken(String token , UserDetails userDetails){
        try{
            return extractUsername(token).equals(userDetails.getUsername());
        }catch (SecurityException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex){
            throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
        }catch (ExpiredJwtException ex){
            throw new ExpiredJwtException(ex.getHeader() , ex.getClaims() , "Session expired");
        }
    }
}
