/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: PostRepo.java, v 0.1 2024-02-01 12:06 AM Ramakant rawat Exp $$
 */
@Repository
public interface PostRepo extends JpaRepository<PostsEntity, Long> {
    List<PostsEntity> findAllByUserIdOrderByGmtCreateDesc(Long userId);
}
