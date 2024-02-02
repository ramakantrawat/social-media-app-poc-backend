/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ramakant rawat
 * @version $Id: CommentRequest.java, v 0.1 2024-02-02 5:26 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
public class CommentRequest {
    private String comment;
    private Long postId;
}
