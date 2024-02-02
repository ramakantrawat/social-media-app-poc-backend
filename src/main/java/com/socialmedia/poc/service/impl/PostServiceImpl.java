/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.enums.PostType;
import com.socialmedia.poc.dto.PostInfo;
import com.socialmedia.poc.dto.User;
import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.entity.*;
import com.socialmedia.poc.exceptions.PostNotExist;
import com.socialmedia.poc.exceptions.UserNotExist;
import com.socialmedia.poc.repository.MediaTypeRepo;
import com.socialmedia.poc.repository.PostInfoRepo;
import com.socialmedia.poc.repository.PostRepo;
import com.socialmedia.poc.repository.UserRepo;
import com.socialmedia.poc.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: PostServiceImpl.java, v 0.1 2024-01-30 9:15 PM Ramakant rawat Exp $$
 */
@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private PostInfoRepo postInfoRepo;
    @Autowired
    private MediaTypeRepo mediaTypeRepo;

    @Override
    public PostResponseList allPost(Long userId) {
        return PostResponseList.builder().posts(
                List.of(PostResponse.
                        builder().
                        user(User.
                                builder().
                                name("").
                                profileUrl("").
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
                                profileUrl("").
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
    public PostResponse getPostById(Long userId, Long postId) {

        PostsEntity postById = postRepo.findById(postId).orElseThrow(PostNotExist::new);

        int likes = postById.getReactions().stream().filter(Reactions::isLikes).toList().size();
        int unlikes = postById.getReactions().stream().filter(Reactions::isUnlikes).toList().size();

        return PostResponse.
                builder().
                user(User.
                        builder().
                        name(postById.getUser().getFname()).
                        profession(postById.getUser().getProfession()).
                        followerCount(null).
                        build()).
                postType(PostType.TEXT).
                textorfeed("helloTexts").
                postInfo(PostInfo.
                        builder().
                        commentCount(postById.getComments().size()).
                        likeCount(likes).
                        unlikeCount(unlikes).
                        build()).
                likedByMe(checkPostAlreadyLikedByUser(userId, postId)).
                dislikeByMe(checkPostAlreadyDisLikedByUser(userId, postId)).
                build();
    }

    @Override
    public Long createPost(PostRequest postRequest, Long userId) {
        log.info("Checking user is exist or not");
        UserEntity userEntity = userRepo.findById(userId).orElseThrow(UserNotExist::new);
        log.info("User is exist");

        MediaTypeEntity mediaType = mediaTypeRepo.findByType(postRequest.getMediaType().getType());
        log.info("fetched mediaType from db");

        PostsEntity post =
                PostsEntity.
                        builder().
                        user(userEntity).
                        gmtCreate(new Date()).
                        gmtUpdate(new Date()).
                        build();
        PostsEntity savedPost = postRepo.save(post);
        PostMetaData postMetaData =
                PostMetaData.
                        builder().
                        post(post).
                        text(postRequest.getText()).
                        isPublic(postRequest.getIsPublic()).
                        post(post).
                        mediaType(mediaType).
                        mediaUrl(postRequest.getMedia()).
                        gmtCreate(new Date()).
                        gmtUpdate(new Date()).
                        build();
        postInfoRepo.save(postMetaData);
        log.info("Post Id is: " + savedPost.getId());
        return savedPost.getId();
    }

    private boolean checkPostAlreadyLikedByUser(Long userId, Long postId) {
        PostsEntity postById = postRepo.findById(postId).orElseThrow(PostNotExist::new);
        return postById.getReactions().
                stream().
                filter(Reactions::isLikes).
                anyMatch(reactions -> reactions.getUser().getId().equals(userId));
    }

    private boolean checkPostAlreadyDisLikedByUser(Long userId, Long postId) {
        PostsEntity postById = postRepo.findById(postId).orElseThrow(PostNotExist::new);
        return postById.getReactions().
                stream().
                filter(Reactions::isUnlikes).
                anyMatch(reactions -> reactions.getUser().getId().equals(userId));
    }
}
