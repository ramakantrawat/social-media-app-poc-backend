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
 * @version $Id: Tag.java, v 0.1 2024-01-30 10:34 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@Builder
@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<PostsEntity> post;
}
