/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.controller.Post;
import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostCreatedResponse;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.service.PostService;
import org.springframework.http.HttpStatus;
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

    public PostImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public PostResponseList getAllPosts() {
        return postService.allPost();
    }

    @Override
    public PostResponse getById(String id) {
        return postService.getPostById(id);
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
