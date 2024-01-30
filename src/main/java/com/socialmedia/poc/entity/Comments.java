/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ramakant rawat
 * @version $Id: Comments.java, v 0.1 2024-01-30 10:08 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
@Table(name = "comments")
public class Comments extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserEntity byUser;
    private String comment;
}
