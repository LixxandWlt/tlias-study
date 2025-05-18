package com.study.exception;

import com.study.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 类名称：GlobalExceptionHandler
 * 描述：全局异常处理程序
 *
 * @author: Lixx
 * 创建时间: 2025/03/16
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result error(Exception e) {
        log.error("程序出错！！", e);
        return Result.error("服务器发生异常");
    }

    @ExceptionHandler
    public Result error(DuplicateKeyException e) {
        log.error("程序出错！！", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMessage = message.substring(i);
        String[] arr = errMessage.split(" ");
        return Result.error(arr[2] + "已存在");
    }

}
