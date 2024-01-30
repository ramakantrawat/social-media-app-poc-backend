/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: LikeOrUnlike.java, v 0.1 2024-01-30 10:11 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
@Table(name = "reactions")
public class Reactions extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long like;
    private Long unlike;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserEntity byUser;
}
