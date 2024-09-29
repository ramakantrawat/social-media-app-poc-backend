/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.UserDto;
import com.socialmedia.poc.dto.UserListDto;
import com.socialmedia.poc.dto.UserProfileDto;
import com.socialmedia.poc.dto.requests.AuthRequest;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.dto.requests.FollowRequest;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: UserService.java, v 0.1 2024-02-02 7:56 PM Ramakant rawat Exp $$
 */
public interface UserService {
    void createUser(CreateUserRequest createUserRequest);
    String createToken(AuthRequest authRequest);
    Boolean follow(Long followBy, FollowRequest followRequest);
    UserListDto followers(Long userId);
    UserListDto following(Long userId);
    UserProfileDto myProfile(Long userId);

}
