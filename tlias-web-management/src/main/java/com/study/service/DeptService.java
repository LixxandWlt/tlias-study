package com.study.service;

import com.study.pojo.Dept;

import java.util.List;

/**
 * 业务接口
 */
public interface DeptService {

    /**
     * 查找全部
     * @return {@link List }<{@link Dept }>
     * @author KM
     * @date 2025/03/04
     */
    List<Dept> findAll();

    /**
     * 按 ID 删除
     *
     * @param id 身份证
     * @author KM
     * @date 2025/03/04
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */
    void add(Dept dept);

    /**
     * 按 ID 获取部门数据
     *
     * @param id 编号
     * @return {@link Dept }
     * @author KM
     * @date 2025/03/04
     */
    Dept getById(Integer id);

    /**
     * 更新部门信息
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */
    void update(Dept dept);
}
