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
 * @version $Id: Comments.java, v 0.1 2024-01-30 10:08 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserInfo byUser;
    private String comment;
    private Date gmtCreate;
    private Date gmtUpdate;
}
