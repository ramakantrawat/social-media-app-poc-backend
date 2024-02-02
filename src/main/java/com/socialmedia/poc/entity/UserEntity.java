/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: UserEntity.java, v 0.1 2024-01-30 10:04 PM Ramakant rawat Exp $$
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String mobile;
    private String profileUrl;
    private String profession;
    @OneToMany
    private List<PostsEntity> posts;

    @OneToMany(mappedBy = "user")
    private List<Reactions> reactions;

    @OneToMany
    private List<Comments> comments;

    private Date gmtCreate;

    private Date gmtUpdate;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", posts=" + posts +
                ", reactions=" + reactions +
                ", comments=" + comments +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
