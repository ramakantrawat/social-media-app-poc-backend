/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmedia.poc.constants.enums.PostType;
import com.socialmedia.poc.dto.PostInfo;
import com.socialmedia.poc.dto.UserDto;
import lombok.*;

/**
 * @author Ramakant rawat
 * @version $Id: PostResponse.java, v 0.1 2024-01-30 9:27 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {
    private Long postId;
    private UserDto user;
    private PostInfo postInfo;
    private PostType postType;
    private String textOrFeed;
    private String postMediaUrl;
    private Boolean likedByMe;
    private Boolean dislikeByMe;
}
