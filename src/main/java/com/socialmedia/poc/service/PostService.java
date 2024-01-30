/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service;

import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;

/**
 * @author Ramakant rawat
 * @version $Id: Post.java, v 0.1 2024-01-30 9:01 PM Ramakant rawat Exp $$
 */
public interface PostService {
    PostResponseList allPost();

    PostResponse getPostById(String id);
}
