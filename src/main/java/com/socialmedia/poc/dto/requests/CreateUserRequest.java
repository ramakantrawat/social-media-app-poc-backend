/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.requests;

import lombok.*;

/**
 * @author Ramakant rawat
 * @version $Id: CreateUserRequest.java, v 0.1 2024-02-02 7:53 PM Ramakant rawat Exp $$
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String mobileNumber;
    private String email;
    private String fName;
    private String lName;
    private String password;
}
