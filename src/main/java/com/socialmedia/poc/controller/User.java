/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller;

import com.socialmedia.poc.dto.requests.AuthRequest;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.dto.requests.FollowRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Ramakant rawat
 * @version $Id: User.java, v 0.1 2024-02-02 7:51 PM Ramakant rawat Exp $$
 */
public interface User {
    @PostMapping("/create")
    void createUser(@RequestBody CreateUserRequest createUserRequest);
    @PostMapping("/generateToken")
    String authenticateAndGetToken(@RequestBody AuthRequest authRequest);
    @PostMapping("/follow")
    Boolean follow(@RequestHeader HttpHeaders httpHeaders, @RequestBody FollowRequest followRequest);
}
