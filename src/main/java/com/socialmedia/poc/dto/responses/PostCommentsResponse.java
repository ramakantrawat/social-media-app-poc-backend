/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.responses;

import com.socialmedia.poc.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ramakant rawat
 * @version $Id: PostCommentsResponse.java, v 0.1 2024-02-02 6:08 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
public class PostCommentsResponse {
    private Long id;
    private UserDto user;
    private String comment;
    private Long loves;
    private Date date;
}
