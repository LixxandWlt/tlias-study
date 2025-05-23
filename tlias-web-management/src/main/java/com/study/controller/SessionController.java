package com.study.controller;

import com.study.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：SessionController
 * 描述：会话控制器
 *
 * @author: Lixx
 * 创建时间: 2025/03/19
 */

@Slf4j
@RestController
public class SessionController {

    /**
     * 设置Cookie
     *
     * @param response 响应
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/19
     */
    @GetMapping("c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("username","zhangsan"));
        return Result.success();
    }

    /**
     * 获取Cookie
     *
     * @param request 请求
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/19
     */
    @GetMapping("c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                System.out.println("login_username: "+cookie.getValue());
            }
        }
        return Result.success();
    }

    /**
     * 设置Session
     *
     * @param session 会话
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/19
     */
    @GetMapping("s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}", session.hashCode());
        session.setAttribute("username","zhangsan");//往session中存储数据
        return Result.success();
    }

    /**
     * 获取Session
     *
     * @param session 会话
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/19
     */

    @GetMapping("s2")
    public Result session2(HttpSession session){
        log.info("HttpSession-s2: {}", session.hashCode());
        Object username = session.getAttribute("username");//从session中获取数据
        log.info("loginUser: {}", username);
        return Result.success(username);
    }
}
