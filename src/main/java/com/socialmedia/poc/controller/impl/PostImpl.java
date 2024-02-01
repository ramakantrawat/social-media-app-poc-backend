/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.controller.Post;
import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.requests.ReactionRequest;
import com.socialmedia.poc.dto.responses.PostCreatedResponse;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.service.PostService;
import com.socialmedia.poc.service.ReactionService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramakant rawat
 * @version $Id: PostImpl.java, v 0.1 2024-01-30 9:03 PM Ramakant rawat Exp $$
 */
@RequestMapping("/posts")
@RestController
public class PostImpl implements Post {
    private PostService postService;

    private ReactionService reactionService;

    public PostImpl(PostService postService, ReactionService reactionService) {
        this.postService = postService;
        this.reactionService = reactionService;
    }

    @Override
    public PostResponseList getAllPosts(Long userId) {
        return postService.allPost(userId);
    }

    @Override
    public PostResponse getById(Long userId, Long id) {
        return postService.getPostById(userId, id);
    }


    @Override
    public ResponseEntity<PostCreatedResponse> createPost(PostRequest postRequest, Long userId) {
        postService.createPost(postRequest, userId);
        return new ResponseEntity<>(
                PostCreatedResponse.
                        builder().
                        message(StringConstants.Post.POST_CREATED_SUCCESS).
                        build(),
                HttpStatusCode.valueOf(200));
    }
}
