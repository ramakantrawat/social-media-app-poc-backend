/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * @author Ramakant rawat
 * @version $Id: LikeOrUnlike.java, v 0.1 2024-01-30 10:11 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(columnDefinition = "0")
    private boolean likes;
//    @Column(columnDefinition = "0")
    private boolean unlikes;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserEntity user;
    private Date gmtCreate;
    private Date gmtUpdate;
}
