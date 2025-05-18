package com.study.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * 类名称：JwtUtils
 * 描述：JWT 工具类
 *
 * @author: Lixx
 * 创建时间: 2025/03/20
 */

public class JwtUtils {
    public static final String signKey  = "c3R1ZHk="; // 密钥
    private static Long expire = 43200000L; // 过期时间，单位：毫秒，默认 12 小时

    /**
     * 创建令牌
     *
     * @param claims 负载信息
     * @return {@link String } 令牌
     * @author Lixx
     * @date 2025/03/20
     */

    public static String createToken(Map<String,Object> claims) {
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)// 设置签名算法 和 密钥
                .addClaims(claims)// 设置负载信息
                .setExpiration(new Date(System.currentTimeMillis() + expire))// 设置过期时间
                .compact();// 生成 token
        return token;
    }

    /**
     * 解析 JWT
     *
     * @param token 令 牌
     * @return {@link Claims } 负载信息
     * @author Lixx
     * @date 2025/03/20
     */

    public static Claims parseJWT(String token){
        Claims body = Jwts.parser()
                .setSigningKey(signKey)// 设置密钥
                .parseClaimsJws(token)// 解析 token
                .getBody();// 获取负载信息
        return body;
    }
}
