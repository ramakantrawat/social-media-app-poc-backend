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
import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: UserEntity.java, v 0.1 2024-01-30 10:04 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<PostsEntity> posts;

    @OneToMany
    private List<Reactions> reactions;

    @OneToMany
    private List<Comments> comments;

    private Date gmtCreate;

    private Date gmtUpdate;
}
