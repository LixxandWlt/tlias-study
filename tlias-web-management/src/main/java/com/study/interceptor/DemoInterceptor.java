package com.study.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类名称：DemoInterceptor
 * 描述：演示拦截器
 *
 * @author: Lixx
 * 创建时间: 2025/03/23
 */

@Slf4j
//@Component
public class DemoInterceptor implements HandlerInterceptor {
    /**
     * 目标资源方法执行前执行。 返回true：放行    返回false：不放行
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return boolean
     * @author Lixx
     * @date 2025/03/23
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle执行了");
        return true;
    }

    /**
     * 目标资源方法执行后执行。
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理器
     * @param modelAndView 模型和视图
     * @author Lixx
     * @date 2025/03/23
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行了");
    }

    /**
     * 视图渲染完毕后执行，最后执行
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @param ex       前任
     * @author Lixx
     * @date 2025/03/23
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行了");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
