/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.PostsEntity;
import com.socialmedia.poc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramakant rawat
 * @version $Id: UserRepo.java, v 0.1 2024-02-01 12:07 AM Ramakant rawat Exp $$
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
