/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.dto.UserDto;
import com.socialmedia.poc.dto.requests.CommentRequest;
import com.socialmedia.poc.dto.responses.PostCommentsResponse;
import com.socialmedia.poc.dto.responses.PostCommentsResponseList;
import com.socialmedia.poc.entity.Comments;
import com.socialmedia.poc.entity.PostsEntity;
import com.socialmedia.poc.entity.UserInfo;
import com.socialmedia.poc.exceptions.PostNotExist;
import com.socialmedia.poc.exceptions.UserNotExist;
import com.socialmedia.poc.repository.CommentRepo;
import com.socialmedia.poc.repository.PostRepo;
import com.socialmedia.poc.repository.UserInfoRepo;
import com.socialmedia.poc.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ramakant rawat
 * @version $Id: PostServiceImpl.java, v 0.1 2024-01-30 9:15 PM Ramakant rawat Exp $$
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public boolean doCommentOnPost(Long userId, CommentRequest commentRequest) {
        UserInfo user = userInfoRepo.findById(userId).orElseThrow(UserNotExist::new);
        PostsEntity post = postRepo.findById(commentRequest.getPostId()).orElseThrow(PostNotExist::new);
        Comments comment = Comments.
                builder().
                comment(commentRequest.getComment()).
                byUser(user).
                post(post).
                gmtCreate(new Date()).
                gmtUpdate(new Date()).
                build();
        commentRepo.save(comment);
        return true;
    }

    @Override
    public PostCommentsResponseList getCommentsOnPost(Long postId, Long userId) {
        List<Comments> commentsList = commentRepo.findAllByPostId(postId);
        return PostCommentsResponseList.builder().comments(
                commentsList.
                        stream().
                        map(comments -> commentEntityToCommentResponse(comments, userId)).
                        collect(Collectors.toList())
        ).build();
    }

    PostCommentsResponse commentEntityToCommentResponse(Comments comments, Long userId) {
        UserDto user = UserDto.builder().
                name(comments.getByUser().getId().equals(userId) ? StringConstants.YOU : comments.getByUser().getUser().getFname()).
                profileUrl(comments.getByUser().getProfileUrl()).
                profession(comments.getByUser().getProfession()).build();
        return PostCommentsResponse.
                builder().
                id(comments.getId()).
                user(user).
                comment(comments.getComment()).
                date(comments.getGmtCreate()).
                loves(12L).//todo need to update this after comment reactions part completed
                build();
    }


}
