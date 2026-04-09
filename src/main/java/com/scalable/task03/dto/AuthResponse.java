package com.scalable.task03.dto;

public record AuthResponse(String token, long expiresIn) {
}
