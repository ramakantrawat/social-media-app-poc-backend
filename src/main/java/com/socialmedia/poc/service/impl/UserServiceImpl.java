/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.entity.UserInfo;
import com.socialmedia.poc.repository.exceptions.UserAlreadyExistException;
import com.socialmedia.poc.repository.UserRepo;
import com.socialmedia.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author Ramakant rawat
 * @version $Id: UserServiceImpl.java, v 0.1 2024-02-02 7:57 PM Ramakant rawat Exp $$
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        chkMobAnDEmlExst(createUserRequest.getEmail(), createUserRequest.getMobileNumber());

        UserInfo user = UserInfo.
                builder().
                fname(createUserRequest.getFName()).
                lname(createUserRequest.getLName()).
                email(createUserRequest.getEmail()).
                gmtCreate(new Date()).
                gmtUpdate(new Date()).
                mobile(createUserRequest.getMobileNumber()).
                build();
        userRepo.save(user);
    }

    private void chkMobAnDEmlExst(String email, String mobileNumber) {
        if (Objects.nonNull(userRepo.findByEmail(email))) {
            throw new UserAlreadyExistException(StringConstants.EMAIL_ALREADY_EXIST);
        } else if (Objects.nonNull(userRepo.findByMobile(mobileNumber))) {
            throw new UserAlreadyExistException(StringConstants.MOBILE_ALREADY_EXIST);
        }
    }

}
