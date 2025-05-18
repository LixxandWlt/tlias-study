package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.mapper.ClazzMapper;
import com.study.mapper.StudentMapper;
import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import com.study.pojo.PageResult;
import com.study.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询列表
     *
     * @param clazzQueryParam clazz query param
     * @return {@link PageResult }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/24
     */

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        // TODO: 引入PageHelper分页插件
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        // TODO: 查询分页数据
        List<Clazz> clazzList  = clazzMapper.list(clazzQueryParam);

        // TODO: 封装数据
        Page<Clazz> pageObj = (Page<Clazz>) clazzList;
        return new PageResult<>(pageObj.getTotal(), pageObj.getResult());
    }


    /**
     * 保存
     *
     * @param clazz 班级对象
     * @author Lixx
     * @date 2025/04/27
     */

    @Override
    public void save(Clazz clazz) {
        // TODO 补全数据
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    /**
     * 按 ID 查找
     *
     * @param id 身份证
     * @return {@link Clazz }
     * @author Lixx
     * @date 2025/04/28
     */

    @Override
    public Clazz findById(Integer id) {
        return clazzMapper.findById(id);
    }

    /**
     * 更新
     *
     * @param clazz 班级对象
     * @author Lixx
     * @date 2025/05/06
     */

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 按 ID 删除
     *
     * @param id id
     * @author Lixx
     * @date 2025/05/07
     */

    @Override
    public void deleteById(Integer id) {
        // TODO: 判断班级是否有学生
        Integer count = studentMapper.countStudentByClazzId(id);
        if (count > 0) {
            // TODO: 如果有学生，则不能删除班级
            throw new RuntimeException("班级有学生，不能删除");
        }
        // TODO: 如果没有学生，则删除班级
        clazzMapper.deleteById(id);
    }

    /**
     * 查找全部
     *
     * @return {@link List }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/24
     */

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
