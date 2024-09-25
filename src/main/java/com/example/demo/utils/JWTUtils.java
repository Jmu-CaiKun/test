package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;


public class JWTUtils {
    private static String signKey = "jmu_caikun";
    private static Long expire = 3600l * 1000;

    /**
     * 生成JWT令牌;
     */
    public static String generateJMT(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();

        return jwt;
    }

    /**
     * 解析JWT令牌;
     */
    public static Claims parseJMT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }
}
