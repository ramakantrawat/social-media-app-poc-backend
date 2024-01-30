/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.controller.Post;
import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.service.PostService;
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
    public PostResponse createPost(PostRequest postRequest) {
        return null;
    }
}
