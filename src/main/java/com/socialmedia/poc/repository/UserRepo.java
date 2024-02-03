/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramakant rawat
 * @version $Id: UserRepo.java, v 0.1 2024-02-01 12:07 AM Ramakant rawat Exp $$
 */
@Repository
public interface UserRepo extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);

    UserInfo findByMobile(String mobile);
}
