package com.project.ecommerce.mbg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberIcon {
    private Integer id;

    private Integer memberId;

    private String filename;

    private static final long serialVersionUID = 1L;
}
