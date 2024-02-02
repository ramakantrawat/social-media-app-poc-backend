/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.controller.Comment;
import com.socialmedia.poc.dto.requests.CommentRequest;
import com.socialmedia.poc.dto.responses.PostCommentsResponseList;
import com.socialmedia.poc.service.CommentService;
import com.socialmedia.poc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ramakant rawat
 * @version $Id: CommentImpl.java, v 0.1 2024-02-02 5:24 PM Ramakant rawat Exp $$
 */
@RequestMapping("/comment")
@RestController
public class CommentImpl implements Comment {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @Override
    public ResponseEntity<Object> doCommentOnPost(@RequestHeader Long userId, @RequestBody CommentRequest commentRequest) {
        return new ResponseEntity<>(commentService.doCommentOnPost(userId, commentRequest), HttpStatus.OK);
    }

    @Override
    public PostCommentsResponseList viewCommentsOnPost(@PathVariable Long postId, @RequestHeader Long userId) {
        return commentService.getCommentsOnPost(postId, userId);
    }
}
