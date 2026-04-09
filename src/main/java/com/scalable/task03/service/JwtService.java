package com.scalable.task03.service;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.scalable.task03.config.JwtConfig;
import com.scalable.task03.model.User;

import io.jsonwebtoken.Claims;

@Service
public class JwtService {

    private final JwtConfig jwtConfig;

    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    // TODO: See Task 3 spec — JwtService.

    String generateToken(User user) {
        return null;
    }

    String extractUsername(String token) {
        return null;
    }

    boolean isTokenValid(String token) {
        return false;
    }

    Claims extractClaims(String token) {
        return null;
    }

    SecretKey getSigningKey() {
        return null;
    }
}
