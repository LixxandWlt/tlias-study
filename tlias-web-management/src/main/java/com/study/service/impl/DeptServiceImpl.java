package com.study.service.impl;

import com.study.mapper.DeptMapper;
import com.study.pojo.Dept;
import com.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 类名称：DeptServiceImpl
 * 描述：服务层，数据处理
 *
 * @author: KM
 * 创建时间: 2025/03/03
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查找全部
     * @return {@link List }<{@link Dept }>
     * @author KM
     * @date 2025/03/04
     */

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = deptMapper.findAll();
        return depts;
    }

    /**
     * 删除
     * @param id 删除的id
     * @author KM
     * @date 2025/03/04
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */

    @Override
    public void add(Dept dept) {
        // TODO: 补全对象中的属性，createTime、updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        // TODO: 调用mapper层，完成插入
        deptMapper.insert(dept);

    }

    /**
     * 按 ID 获取部门信息
     *
     * @param id 编号
     * @return {@link Dept }
     * @author KM
     * @date 2025/03/04
     */
    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }

    /**
     * 更新部门信息
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */
    @Override
    public void update(Dept dept) {
        //TODO: 补全对象中的属性，updateTime
        dept.setUpdateTime(LocalDateTime.now());

        //TODO: 调用mapper层，完成更新
        deptMapper.update(dept);

    }
}

