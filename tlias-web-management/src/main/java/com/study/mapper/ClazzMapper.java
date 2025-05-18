package com.study.mapper;

import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询列表
     *
     * @param clazzQueryParam clazz query param
     * @return {@link List }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/24
     */

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 查找全部
     *
     * @return {@link List }<{@link Clazz }>
     * @author Lixx
     * @date 2025/04/27
     */

    List<Clazz> findAll();

    /**
     * 保存
     *
     * @param clazz 班级对象
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

    void deleteById(Integer id);
}
