package com.study.service.impl;

import com.study.mapper.EmpLogMapper;
import com.study.pojo.EmpLog;
import com.study.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    /**
     * 插入日志
     *
     * @param empLog EMP 日志
     * @author KM
     * @date 2025/03/11
     */

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)// REQUIRES_NEW 表示开启新事务
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
