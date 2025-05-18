package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.mapper.OperateLogMapper;
import com.study.pojo.LogQueryParam;
import com.study.pojo.OperateLog;
import com.study.pojo.PageResult;
import com.study.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> list(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        List<OperateLog> operateLogList = operateLogMapper.list(logQueryParam);
        Page<OperateLog> operateLogPage = (Page<OperateLog>) operateLogList;
        return new PageResult<>(operateLogPage.getTotal(), operateLogPage.getResult());
    }
}
