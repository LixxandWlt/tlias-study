package com.study.service;

import com.study.pojo.PageResult;
import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 分页查询
     *
     * @param studentQueryParam student 查询参数
     * @return {@link PageResult }<{@link Student }>
     * @author Lixx
     * @date 2025/05/08
     */

    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    void save(Student student);

    /**
     * 按 ID 查找
     *
     * @param id id
     * @return {@link Student }
     * @author Lixx
     * @date 2025/05/09
     */

    Student getById(Integer id);

    /**
     * 更新
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    void update(Student student);

    /**
     * 按 ID 批量删除
     *
     * @param ids IDS
     * @author Lixx
     * @date 2025/05/09
     */

    void deleteByIds(List<Integer> ids);

    /**
     * 违纪
     *
     * @param id    身份证
     * @param score 扣分
     * @author Lixx
     * @date 2025/05/11
     */

    void violation(Integer id, Integer score);
}
