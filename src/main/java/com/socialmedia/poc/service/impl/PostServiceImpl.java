/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.enums.PostType;
import com.socialmedia.poc.dto.PostInfo;
import com.socialmedia.poc.dto.User;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: PostServiceImpl.java, v 0.1 2024-01-30 9:15 PM Ramakant rawat Exp $$
 */
@Service
public class PostServiceImpl implements PostService {
    @Override
    public PostResponseList allPost() {
        return PostResponseList.builder().posts(
                List.of(PostResponse.
                        builder().
                        user(User.
                                builder().
                                name("").
                                profile("").
                                followerCount(0).
                                build()).
                        postType(PostType.TEXT).
                        textorfeed("helloTexts").
                        postInfo(PostInfo.
                                builder().
                                commentCount(2).
                                likeCount(100).
                                build()).
                        build(), PostResponse.
                        builder().
                        user(User.
                                builder().
                                name("").
                                profile("").
                                followerCount(null).
                                build()).
                        postType(PostType.IMAGE).
                        postImagePath("this  is the image path").
                        postInfo(PostInfo.
                                builder().
                                commentCount(2).
                                likeCount(100).
                                build()).
                        build())
        ).build();

    }

    @Override
    public PostResponse getPostById(String id) {
        return PostResponse.
                builder().
                user(User.
                        builder().
                        name("").
                        profile("").
                        followerCount(null).
                        build()).
                postType(PostType.TEXT).
                textorfeed("helloTexts").
                postInfo(PostInfo.
                        builder().
                        commentCount(2).
                        likeCount(100).
                        build()).
                build();
    }
}
