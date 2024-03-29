/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ramakant rawat
 * @version $Id: UserRepo.java, v 0.1 2024-02-01 12:07 AM Ramakant rawat Exp $$
 */
@Repository
public interface FollowersRepo extends JpaRepository<Followers, Long> {
    Optional<Followers> findByFollowedByIdAndFollowedToId(Long followedBy, Long followedTo);
    List<Followers> findByFollowedToId(Long id);
    List<Followers> findByFollowedById(Long id);
}
