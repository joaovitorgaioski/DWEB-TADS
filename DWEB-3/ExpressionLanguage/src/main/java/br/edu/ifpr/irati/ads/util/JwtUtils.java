package br.edu.ifpr.irati.ads.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Set;

public class JwtUtils {

    public static String generateToken(String subject, String[] roles, Long expirationMillis, String jwtPasswd) {
        jwtPasswd = jwtPasswd + "0".repeat(Math.max(0, 32 - jwtPasswd.length()));
        SecretKey key = Keys.hmacShaKeyFor(jwtPasswd.getBytes());

        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .audience().add(Set.of(roles)).and()
                .compact();
    }

    public static Claims validateToken(String token, String jwtPasswd) {
        jwtPasswd = jwtPasswd + "0".repeat(Math.max(0, 32 - jwtPasswd.length()));
        SecretKey key = Keys.hmacShaKeyFor(jwtPasswd.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
