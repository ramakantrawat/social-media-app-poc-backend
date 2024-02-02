/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.controller;

import com.socialmedia.poc.constants.StringConstants;
import com.socialmedia.poc.dto.responses.GeneralErrorResponse;
import com.socialmedia.poc.exceptions.PostNotExist;
import com.socialmedia.poc.exceptions.UserAlreadyExistException;
import com.socialmedia.poc.exceptions.UserNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ramakant rawat
 * @version $Id: ExceptionHandler.java, v 0.1 2024-02-01 1:17 AM Ramakant rawat Exp $$
 */
@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<GeneralErrorResponse> userNotExist(UserNotExist userNotExist) {
        return new ResponseEntity<>(
                GeneralErrorResponse.
                        builder().
                        errorCode(HttpStatus.BAD_REQUEST.value()).
                        message(StringConstants.USER_NOT_EXIST).
                        build(),
                HttpStatusCode.valueOf(503));
    }

    @ExceptionHandler(PostNotExist.class)
    public ResponseEntity<GeneralErrorResponse> postNotExistException(PostNotExist postNotExist) {
        return new ResponseEntity<>(
                GeneralErrorResponse.
                        builder().
                        errorCode(HttpStatus.BAD_REQUEST.value()).
                        message(StringConstants.Post.POST_NOT_EXIST).
                        build(),
                HttpStatusCode.valueOf(503));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<GeneralErrorResponse> userAlreadyExistException(UserAlreadyExistException postNotExist) {
        return new ResponseEntity<>(
                GeneralErrorResponse.
                        builder().
                        errorCode(HttpStatus.CONFLICT.value()).
                        message(postNotExist.getMessage()).
                        build(),
                HttpStatusCode.valueOf(409));
    }
}
