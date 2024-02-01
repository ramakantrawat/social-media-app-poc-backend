/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.service.impl;

import com.socialmedia.poc.dto.requests.ReactionRequest;
import com.socialmedia.poc.entity.PostsEntity;
import com.socialmedia.poc.entity.Reactions;
import com.socialmedia.poc.entity.UserEntity;
import com.socialmedia.poc.exceptions.PostNotExist;
import com.socialmedia.poc.exceptions.UserNotExist;
import com.socialmedia.poc.repository.*;
import com.socialmedia.poc.service.ReactionService;
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
public class ReactionServiceImpl implements ReactionService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private PostInfoRepo postInfoRepo;
    @Autowired
    private MediaTypeRepo mediaTypeRepo;
    @Autowired
    private ReactionRepo reactionRepo;

    @Override
    public boolean reaction(Long userId, ReactionRequest reactionRequest) {

        if (reactionRequest.isILike()&&reactionRequest.isIDisLike()){
            throw new PostNotExist();
        }

        Long postId = reactionRequest.getPostId();
        List<Reactions> reactionsList = reactionRepo.findAllByUserIdAndPostId(userId, postId);

        UserEntity user = userRepo.findById(userId).orElseThrow(UserNotExist::new);
        PostsEntity post = postRepo.findById(reactionRequest.getPostId()).orElseThrow(PostNotExist::new);

        if (reactionsList.isEmpty()) {
            Reactions reactions = Reactions.
                    builder().
                    user(user).
                    post(post).
                    likes(reactionRequest.isILike()).
                    unlikes(reactionRequest.isIDisLike()).
                    gmtCreate(new Date()).
                    gmtUpdate(new Date()).
                    build();
            reactionRepo.save(reactions);
            return true;
        } else {
            if (reactionsList.size()==1){
                Reactions reactions = reactionsList.get(0);
                reactions.setLikes(reactionRequest.isILike());
                reactions.setUnlikes(reactionRequest.isIDisLike());
                reactions.setGmtUpdate(new Date());
                reactionRepo.save(reactions);
                return true;
            }
            for (Reactions reaction: reactionsList) {
                reactionRepo.delete(reaction);
            }
            Reactions reactions = Reactions.
                    builder().
                    user(user).
                    post(post).
                    likes(reactionRequest.isILike()).
                    unlikes(reactionRequest.isIDisLike()).
                    gmtCreate(new Date()).
                    gmtUpdate(new Date()).
                    build();
            reactionRepo.save(reactions);
            return true;
        }
    }
}
