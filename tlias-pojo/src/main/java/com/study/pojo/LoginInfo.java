package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名称：LoginInfo
 * 描述：登录结果封装类
 *
 * @author: Lixx
 * 创建时间: 2025/03/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    /**
     * 员工ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 名字
     */
    private String name;
    /**
     * 令 牌
     */
    private String token;
}
