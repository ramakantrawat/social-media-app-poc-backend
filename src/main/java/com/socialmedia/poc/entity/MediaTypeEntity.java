/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Ramakant rawat
 * @version $Id: MediaTypeEntity.java, v 0.1 2024-02-01 1:57 AM Ramakant rawat Exp $$
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "media_type")
public class MediaTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Byte id;
    private String type;
}


