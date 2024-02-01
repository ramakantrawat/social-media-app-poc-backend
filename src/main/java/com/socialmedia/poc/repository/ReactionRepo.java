/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ramakant rawat
 * @version $Id: ReactionRepo.java, v 0.1 2024-02-01 11:25 PM Ramakant rawat Exp $$
 */
@Repository
public interface ReactionRepo extends JpaRepository<Reactions, Long> {
    List<Reactions> findAllByUserIdAndPostId(Long userId, Long postId);
}
