/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.controller.User;
import com.socialmedia.poc.dto.requests.AuthRequest;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.dto.requests.FollowRequest;
import com.socialmedia.poc.service.UserService;
import com.socialmedia.poc.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramakant rawat
 * @version $Id: UserImpl.java, v 0.1 2024-02-02 7:52 PM Ramakant rawat Exp $$
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UserImpl implements User {
    @Autowired
    private UserService userService;


    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
    }

    @Override
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return userService.createToken(authRequest);
    }

    @Override
    public Boolean follow(HttpHeaders httpHeaders, FollowRequest followRequest) {
        Long followBy = TokenUtil.getUserIdByToken(httpHeaders);
        return userService.follow(followBy, followRequest);
    }
}