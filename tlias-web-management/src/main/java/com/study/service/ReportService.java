package com.study.service;

import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {


    /**
     * 统计各个职位的员工人数
     *
     * @return {@link JobOption } 职位统计结果类
     * @author Lixx
     * @date 2025/03/16
     */

    JobOption getEmpJobData();

    /**
     * 统计性别数
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/03/17
     */

    List<Map<String, Object>> getEmpGenderData();

    /**
     * 获取学生学历数据
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/05/11
     */

    List<Map<String, Object>> getStudentDegreeData();

    /**
     * 班级人数统计
     *
     * @return {@link ClazzOption }
     * @author Lixx
     * @date 2025/05/11
     */

    ClazzOption getStudentCountData();
}
