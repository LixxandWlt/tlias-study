package com.study.mapper;

import com.study.pojo.LogQueryParam;
import com.study.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类名称：OperateLogMapper
 * 描述：操作日志记录
 *
 * @author: Lixx
 * 创建时间: 2025/03/25
 */

@Mapper
public interface OperateLogMapper {
    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Select("select log.* ,e.name  from operate_log log left join emp e on e.id = log.operate_emp_id")
    List<OperateLog> list(LogQueryParam logQueryParam);
}
