package com.study.service;

import com.study.pojo.ClazzQueryParam;
import com.study.pojo.LogQueryParam;
import com.study.pojo.OperateLog;
import com.study.pojo.PageResult;

public interface OperateLogService {

    PageResult<OperateLog> list(LogQueryParam logQueryParam);
}
