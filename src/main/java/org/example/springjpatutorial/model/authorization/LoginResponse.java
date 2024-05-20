package org.example.springjpatutorial.model.authorization;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
}
