package com.eucomida.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
  private final String SECRET_KEY = "secreta123"; // Use uma chave segura!

  public String generateToken(String username) {
    long expirationTime = 86400000L; // 1 dia de expiração

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
  }
}
