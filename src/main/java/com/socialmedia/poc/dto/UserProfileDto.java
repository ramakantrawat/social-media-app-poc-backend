package com.socialmedia.poc.dto;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserProfileDto {
    private String name;
    private String email;
    private String mobile;
}
