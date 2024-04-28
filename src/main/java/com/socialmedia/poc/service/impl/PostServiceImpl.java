/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.enums.PostType;
import com.socialmedia.poc.dto.PostInfo;
import com.socialmedia.poc.dto.UserDto;
import com.socialmedia.poc.dto.requests.PostRequest;
import com.socialmedia.poc.dto.responses.PostResponse;
import com.socialmedia.poc.dto.responses.PostResponseList;
import com.socialmedia.poc.entity.*;
import com.socialmedia.poc.exceptions.PostNotExist;
import com.socialmedia.poc.exceptions.UserNotExist;
import com.socialmedia.poc.repository.*;
import com.socialmedia.poc.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private FollowersRepo followersRepo;

    @Override
    public PostResponseList allPost(Long userId) {

        List<PostsEntity> postsEntityList = postRepo.findAllByOrderByGmtCreateDesc();
        if (postsEntityList.isEmpty()) {
            log.info("This user didn't create any post yet");
        }
        List<PostResponse> postResponseList = new ArrayList<>();
        postsEntityList.forEach(postsEntity -> postResponseList.add(mapPostToResponse(postsEntity, userId)));
        return PostResponseList.builder().posts(postResponseList).build();
    }

    @Override
    public PostResponse getPostById(Long userId, Long postId) {
        PostsEntity postsEntity = postRepo.findById(postId).orElseThrow(PostNotExist::new);
        return mapPostToResponse(postsEntity, userId);
    }

    @Override
    public Long createPost(PostRequest postRequest, Long userId) {
        log.info("Checking user is exist or not");
        UserInfo userEntity = userRepo.findById(userId).orElseThrow(UserNotExist::new);
        log.info("User is exist");

        MediaTypeEntity mediaType = mediaTypeRepo.findByType(postRequest.getMediaType());
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

    PostResponse mapPostToResponse(PostsEntity postsEntity, Long userId) {
        int likes = postsEntity.getReactions().stream().filter(Reactions::isLikes).toList().size();
        int unlikes = postsEntity.getReactions().stream().filter(Reactions::isUnlikes).toList().size();
        List<Followers> followersList = followersRepo.findByFollowedToId(postsEntity.getUser().getId());
        Boolean followedByMe = followersList.stream().anyMatch(followers -> followers.getFollowedBy().getId().equals(userId));
        Long followers = followersList.stream().count();

        return PostResponse.
                builder().
                postId(postsEntity.getId()).
                user(UserDto.
                        builder().
                        userId(postsEntity.getUser().getId()).
                        profileUrl(postsEntity.getUser().getProfileUrl()).
                        name(postsEntity.getUser().getFname()).
                        profession(postsEntity.getUser().getProfession()).
                        followerCount(followers).
                        followedByMe(followedByMe).
                        isThisMe(postsEntity.getUser().getId().equals(userId)).
                        build()).
                postType(PostType.valueOf(postsEntity.getPostMetaData().getMediaType().getType())).
                textOrFeed(postsEntity.getPostMetaData().getText()).
                postMediaUrl(postsEntity.getPostMetaData().getMediaUrl()).
                postInfo(PostInfo.
                        builder().
                        commentCount(postsEntity.getComments().size()).
                        likeCount(likes).
                        unlikeCount(unlikes).
                        build()).
                likedByMe(checkPostAlreadyLikedByUser(userId, postsEntity.getId())).
                dislikeByMe(checkPostAlreadyDisLikedByUser(userId, postsEntity.getId())).
                build();
    }
}
