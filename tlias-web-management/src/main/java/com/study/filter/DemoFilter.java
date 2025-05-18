package com.study.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 类名称：DemoFilter
 * 描述：演示过滤器
 *
 * @author: Lixx
 * 创建时间: 2025/03/21
 */
//@WebFilter(urlPatterns = "/*") // 配置过滤器，拦截所有请求
@Slf4j
public class DemoFilter implements Filter {
    /**
     * 初始化方法，在web服务启动时调用，只执行一次
     *
     * @param filterConfig 过滤器配置
     * @author Lixx
     * @date 2025/03/21
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 过滤器初始化。。。");
    }

    /**
     * 拦截到请求，执行过滤操作，执行多次
     *
     * @param servletRequest  Servlet 请求
     * @param servletResponse
     * @param filterChain     Filter Chain （筛选链）
     * @author Lixx
     * @date 2025/03/21
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter 过滤器执行。。。");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 摧毁方法，在 web 服务关闭时调用，只执行一次
     *
     * @author Lixx
     * @date 2025/03/21
     */
    @Override
    public void destroy() {
        log.info("destroy 过滤器销毁。。。");
    }
}
