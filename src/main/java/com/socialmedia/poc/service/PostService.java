/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.exceptions.UserNotExist;

/**
 * @author Ramakant rawat
 * @version $Id: Post.java, v 0.1 2024-01-30 9:01 PM Ramakant rawat Exp $$
 */
public interface PostService {
    PostResponseList allPost(Long userId);
    PostResponseList feedPosts(Long userId);
    PostResponse getPostById(Long userId, Long id);
    Long createPost(PostRequest postRequest, Long userId) throws UserNotExist;
}
