/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ramakant rawat
 * @version $Id: UserNotExist.java, v 0.1 2024-02-01 1:02 AM Ramakant rawat Exp $$
 */
@Slf4j
public class UserNotExist extends RuntimeException{
    public UserNotExist(){
        super();
        log.info("User is Not Exist");
    }

}
