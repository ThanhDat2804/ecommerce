package com.project.ecommerce.security;

import lombok.Data;

@Data
public class LoginRequest {

    //@NotEmpty(message = "username can not be empty")
    String username;

    //@NotEmpty(message = "password can not be empty")
    String password;

}