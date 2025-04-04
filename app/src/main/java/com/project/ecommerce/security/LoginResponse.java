package com.project.ecommerce.security;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private String token;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}