/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ramakant rawat
 * @version $Id: LikeOrUnlike.java, v 0.1 2024-01-30 10:11 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
public class Reactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long likes;
    private Long unlikes;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserEntity byUser;
    private Date gmtCreate;
    private Date gmtUpdate;
}
