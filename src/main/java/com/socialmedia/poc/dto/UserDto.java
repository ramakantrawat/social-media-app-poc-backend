/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author Ramakant rawat
 * @version $Id: User.java, v 0.1 2024-01-30 9:31 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userId;
    private String name;
    private String profileUrl;
    private String profession;
    private Long followerCount;
    private Boolean followedByMe;
    private Boolean isThisMe;
}
