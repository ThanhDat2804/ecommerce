package com.project.ecommerce.dto.UMS;

import com.project.ecommerce.mbg.model.Address;
import com.project.ecommerce.mbg.model.Member;
import com.project.ecommerce.mbg.model.MemberIcon;
import com.project.ecommerce.mbg.model.MemberLoginLog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MemberDetail implements Serializable {
    Member member;
    Address address;
    MemberIcon icon;
    List<MemberLoginLog> loginLogList;
}
