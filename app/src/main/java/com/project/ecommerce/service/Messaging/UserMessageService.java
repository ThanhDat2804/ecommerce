package com.project.ecommerce.service.Messaging;

import com.project.ecommerce.dto.UMS.MemberDetail;
import com.project.ecommerce.dto.event.UMS.UmsUserEvent;
import com.project.ecommerce.mbg.model.Address;
import com.project.ecommerce.mbg.model.Member;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.ecommerce.dto.event.UMS.UmsUserEvent.Type.*;

@Service
public class UserMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserNewMessage(MemberDetail memberDetail) {
        UmsUserEvent event = new UmsUserEvent(NEW_ACCOUNT, memberDetail);
        rabbitTemplate.convertAndSend("", "user", event);
    }

    public void sendUserNewPassWordMessage(String newPassword, int userId) {
        Member member = new Member();
        member.setPassword(newPassword);
        member.setId(userId);

        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setMember(member);
        UmsUserEvent event = new UmsUserEvent(UPDATE_PASSWORD, memberDetail);
        rabbitTemplate.convertAndSend("", "user", event);
    }

    public void sendUserUpdateInfoMessage(MemberDetail memberDetail, int userId) {
        Member member = new Member();
        member.setId(userId);
        memberDetail.setMember(member);
        UmsUserEvent event = new UmsUserEvent(UPDATE_ACCOUNT_INFO, memberDetail);
        rabbitTemplate.convertAndSend("", "user", event);
    }

    public void sendUserUpdateAddressMessage(Address newAddress, int userId) {
        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setAddress(newAddress);
        Member member = new Member();
        member.setId(userId);
        memberDetail.setMember(member);
        UmsUserEvent event = new UmsUserEvent(UPDATE_ADDRESS, memberDetail);
        rabbitTemplate.convertAndSend("", "user", event);
    }

    public void sendUserDeleteAccountMessage(int userId) {
        Member member = new Member();
        member.setId(userId);
        MemberDetail memberDetail = new MemberDetail();
        memberDetail.setMember(member);
        UmsUserEvent event = new UmsUserEvent(DELETE_ACCOUNT, memberDetail);
        rabbitTemplate.convertAndSend("", "user", event);
    }
}