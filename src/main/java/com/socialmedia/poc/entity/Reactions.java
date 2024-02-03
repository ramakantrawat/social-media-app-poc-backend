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
    private boolean likes;
    private boolean unlikes;
    @ManyToOne
    private PostsEntity post;
    @ManyToOne
    private UserInfo user;
    private Date gmtCreate;
    private Date gmtUpdate;

    /*
     * todo:
     *   * need to add reaction type we can do reaction on other component as well like comments etc..
     *
     * */
}
