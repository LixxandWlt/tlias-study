package com.study.service.impl;

import com.study.mapper.EmpMapper;
import com.study.mapper.StudentMapper;
import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;
import com.study.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 统计各个职位的员工人数
     *
     * @return {@link JobOption } 职位统计结果类
     * @author Lixx
     * @date 2025/03/16
     */
    @Override
    public JobOption getEmpJobData() {
        //TODO: 从数据库中查询数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //TODO: 封装数据
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    /**
     * 统计性别数
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/03/17
     */

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.getEmpGenderData();
    }

    /**
     * 获取学生学历数据
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/05/11
     */

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }

    /**
     * 班级人数统计
     *
     * @return {@link ClazzOption }
     * @author Lixx
     * @date 2025/05/11
     */

    @Override
    public ClazzOption getStudentCountData() {
        //TODO: 从数据库中查询数据
        List<Map<String, Object>> list = studentMapper.countEmpJobData();
        //TODO: 封装数据
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("cname")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("scount")).toList();
        return new ClazzOption(clazzList, dataList);
    }
}
