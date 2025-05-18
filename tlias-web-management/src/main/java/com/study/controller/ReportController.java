package com.study.controller;

import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;
import com.study.pojo.Result;
import com.study.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 类名称：ReportController
 * 描述：结果统计控制器
 *
 * @author: Lixx
 * 创建时间: 2025/03/16
 */

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     *
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/16
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("查询员工岗位统计数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计性别数
     *
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/17
     */

    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("查询员工性别统计数据");
        List<Map<String, Object>> list = reportService.getEmpGenderData();
        return Result.success(list);
    }

    /**
     * 获取学生学历数据
     *
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/11
     */

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("查询学生学历统计数据");
        List<Map<String, Object>> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }

    /**
     * 班级人数统计
     *
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/11
     */

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("查询学生学历统计数据");
        ClazzOption clazzOption = reportService.getStudentCountData();
        return Result.success(clazzOption);
    }
}
