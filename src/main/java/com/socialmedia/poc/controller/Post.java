/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller;

import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostCreatedResponse;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Ramakant rawat
 * @version $Id: Post.java, v 0.1 2024-01-30 9:01 PM Ramakant rawat Exp $$
 */

public interface Post {

    @CrossOrigin(origins = "*")
    @GetMapping("/my-post")

    PostResponseList getAllPosts(@RequestHeader HttpHeaders httpHeaders);

    @GetMapping("/{id}")
    PostResponse getById(@RequestHeader HttpHeaders httpHeaders, @PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<PostCreatedResponse> createPost(@RequestBody PostRequest postRequest,
                                                   @RequestHeader HttpHeaders httpHeaders);
}
