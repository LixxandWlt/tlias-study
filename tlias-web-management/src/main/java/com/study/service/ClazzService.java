package com.study.service;

import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import com.study.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 分页查询列表
     *
     * @param clazzQueryParam clazz query param
     * @return {@link PageResult }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/24
     */

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);


    /**
     * 保存
     *
     * @param clazz 克拉兹
     * @author Lixx
     * @date 2025/04/27
     */

    void save(Clazz clazz);

    /**
     * 按 ID 查找
     *
     * @param id 身份证
     * @return {@link Clazz }
     * @author Lixx
     * @date 2025/04/28
     */

    Clazz findById(Integer id);

    /**
     * 更新
     *
     * @param clazz 班级对象
     * @author Lixx
     * @date 2025/05/06
     */

    void update(Clazz clazz);

    /**
     * 按 ID 删除
     *
     * @param id id
     * @author Lixx
     * @date 2025/05/07
     */

    void deleteById(Integer id);

    /**
     * 查找全部
     *
     * @return {@link List }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/27
     */

    List<Clazz> findAll();
}
