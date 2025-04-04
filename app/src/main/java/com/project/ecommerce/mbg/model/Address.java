package com.project.ecommerce.mbg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    private Integer id;

    private Integer memberId;

    private String receiverName;

    private String phoneNumber;

    private String detailAddress;

    private String city;

    private String state;

    private String zipCode;

    private String note;

    private static final long serialVersionUID = 1L;
}