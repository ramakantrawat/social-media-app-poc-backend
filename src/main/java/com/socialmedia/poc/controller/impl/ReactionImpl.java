/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller.impl;

import com.socialmedia.poc.controller.Reaction;
import com.socialmedia.poc.dto.requests.ReactionRequest;
import com.socialmedia.poc.service.PostService;
import com.socialmedia.poc.service.ReactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramakant rawat
 * @version $Id: PostImpl.java, v 0.1 2024-01-30 9:03 PM Ramakant rawat Exp $$
 */
@RequestMapping("/reactions")
@RestController
public class ReactionImpl implements Reaction {
    private PostService postService;

    private ReactionService reactionService;

    public ReactionImpl(PostService postService, ReactionService reactionService) {
        this.postService = postService;
        this.reactionService = reactionService;
    }

    @Override
    public boolean doReact(Long userId, ReactionRequest reactionRequest) {
        return reactionService.reaction(userId, reactionRequest);
    }

}
