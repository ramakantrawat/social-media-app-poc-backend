package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.User;
import com.socialmedia.poc.entity.UserInfo;
import com.socialmedia.poc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserInfo> userDetail = userRepo.findByEmail(email);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found " + email));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userRepo.save(userInfo);
        return "User Added Successfully";
    }
}
