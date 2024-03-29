/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author Ramakant rawat
 * @version $Id: PostInfo.java, v 0.1 2024-01-30 9:31 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostInfo {
    private Integer likeCount;
    private Integer unlikeCount;
    private Integer saves;
    private Integer commentCount;
}
