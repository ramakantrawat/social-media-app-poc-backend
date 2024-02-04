package com.socialmedia.poc.dto.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowRequest {
    private Long followedTo;
}
