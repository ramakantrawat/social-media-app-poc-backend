/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.constants.enums.RolesType;
import com.socialmedia.poc.dto.UserDto;
import com.socialmedia.poc.dto.UserListDto;
import com.socialmedia.poc.dto.UserProfileDto;
import com.socialmedia.poc.dto.requests.AuthRequest;
import com.socialmedia.poc.dto.requests.CreateUserRequest;
import com.socialmedia.poc.dto.requests.FollowRequest;
import com.socialmedia.poc.entity.Followers;
import com.socialmedia.poc.entity.UserInfo;
import com.socialmedia.poc.exceptions.AlreadyFollowedException;
import com.socialmedia.poc.exceptions.UserAlreadyExistException;
import com.socialmedia.poc.exceptions.UserNotExist;
import com.socialmedia.poc.jsonwebtoken.JwtService;
import com.socialmedia.poc.repository.FollowersRepo;
import com.socialmedia.poc.repository.UserRepo;
import com.socialmedia.poc.service.UserService;
import com.socialmedia.poc.util.Converter;
import com.socialmedia.poc.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private FollowersRepo followersRepo;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private EmailUtil emailUtil;

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
                roles(RolesType.USER.getRole()).
                build();
        userRepo.save(user);
        emailUtil.sendEmail(createUserRequest.getEmail(),"Welcome","you are Register to the POC project by dev testing");
    }

    @Override
    public String createToken(AuthRequest authRequest) {
        log.info("authentication method call");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            Optional<UserInfo> email = userRepo.findByEmail(authRequest.getUsername());
            log.info(email.get().getEmail());
            return jwtService.generateToken(authRequest.getUsername(), email.get().getId());
        } else {
            throw new UserNotExist();
        }
    }

    @Override
    public Boolean follow(Long followBy, FollowRequest followRequest) {
        if (followersRepo.findByFollowedByIdAndFollowedToId(followBy, followRequest.getFollowedTo()).isPresent()) {
            throw new AlreadyFollowedException();
        }
        UserInfo byUser = userRepo.findById(followBy).orElseThrow(UserNotExist::new);
        UserInfo toUser = userRepo.findById(followRequest.getFollowedTo()).orElseThrow(UserNotExist::new);
        Followers followers = Followers.builder().followedBy(byUser).followedTo(toUser).build();
        followersRepo.save(followers);
        return true;
    }

    @Override
    public UserListDto followers(Long userId) {
        List<Followers> followingList = followersRepo.findByFollowedToId(userId);
        return UserListDto.builder().users(followingList.stream().map(followers -> Converter.userEntityToFollowingDto(followers.getFollowedBy())).collect(Collectors.toList())).build();
    }

    @Override
    public UserListDto following(Long userId) {
        List<Followers> followedList = followersRepo.findByFollowedById(userId);
        return UserListDto.builder().users(followedList.stream().map(followers -> Converter.userEntityToFollowingDto(followers.getFollowedTo())).collect(Collectors.toList())).build();
    }

    @Override
    public UserProfileDto myProfile(Long userId) {
        Optional<UserInfo> userInfoOptional = userRepo.findById(userId);
        UserInfo userInfo = null;
        if (userInfoOptional.isPresent()){
           userInfo =  userInfoOptional.get();
        }

    return  UserProfileDto.
                builder().
                name(userInfo.getFname()+" "+userInfo.getLname()).
                email(userInfo.getEmail()).
                mobile(userInfo.getMobile()).
                build();


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
