/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.requests;

import lombok.*;

/**
 * @author Ramakant rawat
 * @version $Id: ReactionRequest.java, v 0.1 2024-02-01 11:13 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReactionRequest {
    private Long postId;
    private boolean iLike;
    private boolean iDisLike;
}
