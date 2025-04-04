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
public class MemberLoginLog implements Serializable {
    private Integer id;

    private Integer memberId;

    private Date loginTime;

    private String ipAddress;

    private String loginType;

    private static final long serialVersionUID = 1L;

}