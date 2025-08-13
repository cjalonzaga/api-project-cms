package com.project.api.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "2dae84f846e4f4b158a8d26681707f4338495bc7ab68151d7f7679cc5e56202dd3da0d356da007a7c28cb0b780418f4f3246769972d6feaa8f610c7d1e7ecf6a";

    public String generateToken(UserDetails userDetails){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

        return Jwts.builder().subject(userDetails.getUsername())
                .claim("roles" , userDetails.getAuthorities())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60000L)) //864_000_000
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET) );
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
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
