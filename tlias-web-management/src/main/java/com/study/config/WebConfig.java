package com.study.config;

import com.study.interceptor.DemoInterceptor;
import com.study.interceptor.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类名称：WebConfig
 * 描述：Web 配置类
 *
 * @author: Lixx
 * 创建时间: 2025/03/23
 */

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Autowired
////    private DemoInterceptor demoInterceptor;
//    private TokenInterceptor tokenInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
//    }
}
