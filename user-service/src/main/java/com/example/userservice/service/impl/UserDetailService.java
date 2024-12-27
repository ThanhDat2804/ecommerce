package com.example.userservice.service.impl;

import com.example.userservice.exception.wrapper.EmailOrUsernameNotFoundException;
import com.example.userservice.model.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.principle.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("Email or Username does not exist, please try again: " + username));

        return UserPrinciple.build(user);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("Email or Username does not exist, please try again: " + email));

        return UserPrinciple.build(user);
    }

    @Transactional
    public UserDetails loadUserByPhone(String phone) {
        User user = userRepository.findByEmail(phone)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("User not found, phone and password: " + phone));

        return UserPrinciple.build(user);
    }
}