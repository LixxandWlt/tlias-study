package com.study.controller;


import com.study.pojo.Emp;
import com.study.pojo.LoginInfo;
import com.study.pojo.Result;
import com.study.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：LoginController
 * 描述：登录控制器
 *
 * @author: Lixx
 * 创建时间: 2025/03/17
 */

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录用户信息：{}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }
}
