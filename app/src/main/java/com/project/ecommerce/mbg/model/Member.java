package com.project.ecommerce.mbg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String phoneNumber;

    private String email;

    private Integer status;

    private Integer deleteStatus;

    private Date createdAt;

    private Date lastLogin;

    private String sourceType;

    private static final long serialVersionUID = 1L;
}