/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.*;

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
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserInfo followedBy;
    @ManyToOne
    private UserInfo followedTo;
}
