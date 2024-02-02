/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.requests.CommentRequest;
import com.socialmedia.poc.dto.responses.PostCommentsResponseList;

/**
 * @author Ramakant rawat
 * @version $Id: Post.java, v 0.1 2024-01-30 9:01 PM Ramakant rawat Exp $$
 */
public interface CommentService {
    boolean doCommentOnPost(Long userId, CommentRequest commentRequest);
    PostCommentsResponseList getCommentsOnPost(Long postId, Long userId);
}
