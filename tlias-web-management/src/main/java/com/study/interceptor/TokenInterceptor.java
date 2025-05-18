package com.study.interceptor;

import com.study.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 类名称：TokenInterceptor
 * 描述：令牌拦截器
 *
 * @author: Lixx
 * 创建时间: 2025/03/23
 */

@Slf4j
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // todo: 获取请求头
        String requestURI = request.getRequestURI();

        // todo: 判断是否是登录请求，如果是，则放行
        if (requestURI.contains("/login")) {
            log.info("登录请求，放行");
            return true;
        }

        // todo: 从请求头中获取token
        String token = request.getHeader("token");

        // todo: 判断token是否为空，如果不为空，则解析token,否则返回错误信息（401）
        if (token == null || token.isEmpty()) {
            log.info("令牌为空");
            response.setStatus(401);
            return false;
        }

        // todo: 解析token，如果解析成功，则放行，否则返回错误信息（401）
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("解析令牌失败");
            response.setStatus(401);
            return false;
        }

        // todo: 放行
        log.info("令牌验证成功");
        return true;
    }
}
