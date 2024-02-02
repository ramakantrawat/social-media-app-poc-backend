/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: PostCommentsResponse.java, v 0.1 2024-02-02 6:08 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
public class PostCommentsResponseList {
    List<PostCommentsResponse> comments;
}
