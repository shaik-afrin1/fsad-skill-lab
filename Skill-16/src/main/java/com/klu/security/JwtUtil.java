package com.klu.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {

    private String secret = "mysecretkey"; // you can keep anything

    // 🔹 Generate Token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // 🔹 Extract Username from Token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 🔹 Validate Token
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username);
    }
}