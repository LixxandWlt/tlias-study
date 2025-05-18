package com.study.aop;


import com.study.mapper.OperateLogMapper;
import com.study.pojo.OperateLog;
import com.study.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 类名称：LogAspect
 * 描述：日志记录AOP
 *
 * @author: Lixx
 * 创建时间: 2025/03/25
 */
@Aspect
@Slf4j
@Component
public class LogAspect  {
    @Autowired
    private  OperateLogMapper operateLogMapper;

    @Around("@annotation(com.study.anno.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 执行方法
        Object result = joinPoint.proceed();
        // 当前时间
        long endTime = System.currentTimeMillis();
        // 耗时
        long costTime = endTime - startTime;
        log.info("方法：{}，执行耗时：{} ms", joinPoint.getSignature(), costTime);

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 需要实现 getCurrentUserId 方法
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);

        // 插入日志
        operateLogMapper.insert(operateLog);
        return result;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.get();
    }
}
