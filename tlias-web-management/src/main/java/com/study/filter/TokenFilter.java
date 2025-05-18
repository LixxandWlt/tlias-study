package com.study.filter;

import com.study.utils.CurrentHolder;
import com.study.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 类名称：TokenFilter
 * 描述：令牌筛选器
 *
 * @author: Lixx
 * 创建时间: 2025/03/23
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //todo: 获取请求路径
        String requestURI = request.getRequestURI();

        //todo: 判断是否是登录请求，如果是，则放行
        if (requestURI.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        //todo: 从请求头中获取token
        String token = request.getHeader("token");

        //todo: 判断token是否为空，如果不为空，则解析token,否则返回错误信息（401）
        if (token == null || token.isEmpty()) {
            log.info("令牌为空");
            response.setStatus(401);
            return;
        }

        //todo: 解析token，如果解析成功，则放行，否则返回错误信息（401）
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer empId  = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.set(empId);//存入
            log.info("当前登录员工ID: {}, 将其存入ThreadLocal", empId);
        } catch (Exception e) {
            log.info("解析令牌失败");
            response.setStatus(401);
            return;
        }

        // todo: 放行
        filterChain.doFilter(request, response);

        // todo: 删除ThreadLocal中的数据
        CurrentHolder.remove();
    }
}
