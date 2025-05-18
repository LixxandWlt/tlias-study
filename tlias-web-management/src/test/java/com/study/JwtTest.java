package com.study;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：JwtTest
 * 描述：Jwt令牌生成解析 测试
 *
 * @author: Lixx
 * 创建时间: 2025/03/20
 */

public class JwtTest {

    /**
     * 测试生成 JWT
     *
     * @author Lixx
     * @date 2025/03/20
     */

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "admin");

        String jwt  = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "c3R1ZHk=")//设置编码和密钥
                .addClaims(claims)// 设置自定义数据，该函数的形参要求是Map
                .setExpiration(new Date(System.currentTimeMillis() +  60 * 1000))// 设置过期时间
                .compact();// 生成JWT令牌

        System.out.println(jwt);
        //eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0MjQwMzMxNn0.SrMVRYGnJVZi_TZHpY0QK3W8WHA0nHsLSALTp6Js2wk
    }

    /**
     * 测试解析 JWT
     *
     * @author Lixx
     * @date 2025/03/20
     */

    @Test
    public void testParseJwt() {
        Claims body = Jwts.parser()
                .setSigningKey("c3R1ZHk=")// 设置密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0MjQwMzMxNn0.SrMVRYGnJVZi_TZHpY0QK3W8WHA0nHsLSALTp6Js2wk")
                .getBody();// 获取自定义数据部分，也就是JWT令牌的第二个部分

        System.out.println(body);
    }

}
