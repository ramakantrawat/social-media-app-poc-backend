package com.socialmedia.poc.util;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

@Slf4j
public class TokenUtil {
    public static Long getUserIdByToken(HttpHeaders httpHeaders){
        String authorization = httpHeaders.get("Authorization").get(0);
        String jwt = authorization.replace("Bearer ", "");
        return  Long.valueOf((Integer) Jwts.parser().setSigningKey("5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437").parseClaimsJws(jwt).getBody().get("userId"));
    }
}
