/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.controller.User;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramakant rawat
 * @version $Id: UserImpl.java, v 0.1 2024-02-02 7:52 PM Ramakant rawat Exp $$
 */
@RequestMapping("/user")
@RestController
public class UserImpl implements User {
    @Autowired
    private UserService userService;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
    }
}
