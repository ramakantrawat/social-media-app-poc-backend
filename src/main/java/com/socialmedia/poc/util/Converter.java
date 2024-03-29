package com.socialmedia.poc.util;

import com.socialmedia.poc.dto.UserDto;
import com.socialmedia.poc.entity.UserInfo;

public class Converter {
    public static UserDto userEntityToFollowingDto(UserInfo userInfo) {
        return UserDto.
                builder().
                userId(userInfo.getId()).
                profileUrl(userInfo.getProfileUrl()).
                name(userInfo.getFname() + "" + userInfo.getLname()).
                profession(userInfo.getProfession()).build();
    }
}
