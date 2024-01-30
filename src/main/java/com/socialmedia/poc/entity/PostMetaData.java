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
 * @version $Id: PostInfoEntity.java, v 0.1 2024-01-30 10:15 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
@Table(name = "postMetaData")
public class PostMetaData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "post_postMetaData")
//    private PostsEntity post;

    private String title;
    private String description;

    @Column(nullable = false)
    private boolean isPublic;


}
