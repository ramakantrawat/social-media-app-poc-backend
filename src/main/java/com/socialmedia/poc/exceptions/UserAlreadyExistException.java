/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.exceptions;

/**
 * @author Ramakant rawat
 * @version $Id: GeneralError.java, v 0.1 2024-02-02 8:06 PM Ramakant rawat Exp $$
 */
public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String msg) {
        super(msg);
    }

}
