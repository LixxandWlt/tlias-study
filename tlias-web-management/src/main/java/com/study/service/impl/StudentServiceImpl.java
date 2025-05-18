package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.mapper.StudentMapper;
import com.study.pojo.Clazz;
import com.study.pojo.PageResult;
import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;
import com.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // TODO: 引入PageHelper分页插件
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // TODO: 查询分页数据
        List<Student> clazzList  = studentMapper.page(studentQueryParam);

        // TODO: 封装数据
        Page<Student> pageObj = (Page<Student>) clazzList;
        return new PageResult<>(pageObj.getTotal(), pageObj.getResult());
    }

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    @Override
    public void save(Student student) {
        // TODO 补全数据
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        //  TODO: 新增
        studentMapper.save(student);
    }

    /**
     * 按 ID 查找
     *
     * @param id id
     * @return {@link Student }
     * @author Lixx
     * @date 2025/05/09
     */

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    @Override
    public void update(Student student) {
        //TODO 补全数据
        student.setUpdateTime(LocalDateTime.now());
        // TODO: 更新
        studentMapper.update(student);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 违纪
     *
     * @param id    身份证
     * @param score 扣分
     * @author Lixx
     * @date 2025/05/11
     */

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id, score);
    }
}
