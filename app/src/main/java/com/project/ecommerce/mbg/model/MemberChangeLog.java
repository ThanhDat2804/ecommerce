package com.project.ecommerce.mbg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberChangeLog {
    private Integer id;

    private Integer memberId;

    private String updateAction;

    private String operator;

    private Date createdAt;

    private static final long serialVersionUID = 1L;
}
