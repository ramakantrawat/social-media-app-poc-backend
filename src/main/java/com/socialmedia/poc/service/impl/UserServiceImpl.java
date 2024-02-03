/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.dto.requests.AuthRequest;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.entity.UserInfo;
import com.socialmedia.poc.jsonwebtoken.JwtService;
import com.socialmedia.poc.repository.UserRepo;
import com.socialmedia.poc.repository.exceptions.UserAlreadyExistException;
import com.socialmedia.poc.repository.exceptions.UserNotExist;
import com.socialmedia.poc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Ramakant rawat
 * @version $Id: UserServiceImpl.java, v 0.1 2024-02-02 7:57 PM Ramakant rawat Exp $$
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        chkMobAnDEmlExst(createUserRequest.getEmail(), createUserRequest.getMobileNumber());

        UserInfo user = UserInfo.
                builder().
                fname(createUserRequest.getFName()).
                lname(createUserRequest.getLName()).
                email(createUserRequest.getEmail()).
                password(encoder.encode(createUserRequest.getPassword())).
                gmtCreate(new Date()).
                gmtUpdate(new Date()).
                mobile(createUserRequest.getMobileNumber()).
                build();
        userRepo.save(user);
    }

    @Override
    public String createToken(AuthRequest authRequest) {
        log.info("authentication method call");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            Optional<UserInfo> email = userRepo.findByEmail(authRequest.getUsername());
            return jwtService.generateToken(authRequest.getUsername(),email.get().getId());
        } else {
            throw new UserNotExist();
        }
    }

    private void chkMobAnDEmlExst(String email, String mobileNumber) {
        Optional<UserInfo> emailDb = userRepo.findByEmail(email);
        if (emailDb.isPresent()) {
            throw new UserAlreadyExistException(StringConstants.EMAIL_ALREADY_EXIST);
        } else if (Objects.nonNull(userRepo.findByMobile(mobileNumber))) {
            throw new UserAlreadyExistException(StringConstants.MOBILE_ALREADY_EXIST);
        }
    }

}
