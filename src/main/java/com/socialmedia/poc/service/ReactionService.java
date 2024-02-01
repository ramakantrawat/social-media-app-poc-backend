/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.requests.ReactionRequest;

/**
 * @author Ramakant rawat
 * @version $Id: Post.java, v 0.1 2024-01-30 9:01 PM Ramakant rawat Exp $$
 */
public interface ReactionService {
    boolean reaction(Long userId, ReactionRequest reactionRequest);
}
