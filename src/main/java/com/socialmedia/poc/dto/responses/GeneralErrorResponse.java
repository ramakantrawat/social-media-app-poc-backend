/**
 * Globe FinTech Innovations, Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.socialmedia.poc.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ramakant rawat
 * @version $Id: ErrorResponse.java, v 0.1 2024-02-01 1:35 AM Ramakant rawat Exp $$
 */
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralErrorResponse {
    private String message;
    private Integer errorCode;
}
