package com.study.service;

import com.study.pojo.EmpLog;

/**
 * 类名称：EmpLogService
 * 描述：EMP 日志服务
 *
 * @author: KM
 * 创建时间: 2025/03/11
 */

public interface EmpLogService {
    /**
     * 插入日志
     *
     * @param empLog EMP 日志
     * @author KM
     * @date 2025/03/11
     */

    void insertLog(EmpLog empLog);
}
