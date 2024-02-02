/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.repository;

import com.socialmedia.poc.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: CommentRepo.java, v 0.1 2024-02-02 5:33 PM Ramakant rawat Exp $$
 */
@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {
    List<Comments> findAllByPostId(Long postId);
}
