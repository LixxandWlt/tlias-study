package com.study.controller;

import com.study.pojo.*;
import com.study.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private OperateLogService  operateLogService;

    @GetMapping("/page")
    private Result list(LogQueryParam logQueryParam){
        log.info("分页查询，参数：{}", logQueryParam);
        PageResult<OperateLog> pageResult = operateLogService.list(logQueryParam);
        return Result.success(pageResult);
    }
}
