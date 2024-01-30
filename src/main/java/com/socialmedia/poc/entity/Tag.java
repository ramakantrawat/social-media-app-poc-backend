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
 * @version $Id: Tag.java, v 0.1 2024-01-30 10:34 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@Builder
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<PostsEntity> post;
    private Date gmtCreate;
    private Date gmtUpdate;
}
