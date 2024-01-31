/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import com.socialmedia.poc.dto.MediaType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.Date;

/**
 * @author Ramakant rawat
 * @version $Id: PostInfoEntity.java, v 0.1 2024-01-30 10:15 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PostsEntity post;

    private String text;

    @Column(nullable = false)
    private boolean isPublic = true;
    @ManyToOne
    private MediaTypeEntity mediaType;
    private String mediaUrl;
    private Date gmtCreate;
    private Date gmtUpdate;

}
