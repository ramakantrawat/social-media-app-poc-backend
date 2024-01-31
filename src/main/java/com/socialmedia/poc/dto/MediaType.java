/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ramakant rawat
 * @version $Id: MediaType.java, v 0.1 2024-02-01 1:53 AM Ramakant rawat Exp $$
 */
@Getter
public enum MediaType {
    IMAGE("IMAGE",1),
    VIDEO("VIDEO",1);
    private String type;
    private Integer id;

    MediaType(String type, Integer id) {
        this.type = type;
        this.id = id;
    }
}
