/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller;

import com.socialmedia.poc.dto.requests.CommentRequest;
import com.socialmedia.poc.dto.responses.PostCommentsResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ramakant rawat
 * @version $Id: Comment.java, v 0.1 2024-02-02 5:21 PM Ramakant rawat Exp $$
 */
public interface Comment {
    @PostMapping("/onPost")
    ResponseEntity<Object> doCommentOnPost(Long userId, CommentRequest commentRequest);
    @PostMapping("/allCommentOn/{postId}")
    PostCommentsResponseList viewCommentsOnPost(Long postId, Long userId);
}
