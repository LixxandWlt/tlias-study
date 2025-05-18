package com.study.mapper;

import com.study.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 类名称：DeptMapper
 * 描述：部门数据
 *
 * @author: KM
 * 创建时间: 2025/03/03
 */

@Mapper
public interface DeptMapper {

    /*方式一：手动封装
    * @Results({
            //column：数据库字段名，property：实体类属性名
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    * */

    /*方式二：起别名
    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc ")
    */

    /**
     * 查找全部
     * @return {@link List }<{@link Dept }>
     * @author KM
     * @date 2025/03/04
     */
    @Select("select id, name, create_time, update_time from dept order by update_time desc ")
    List<Dept> findAll();

    /**
     * 按 ID 删除
     *
     * @param id 编号
     * @author KM
     * @date 2025/03/04
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 按 ID 获取部门信息
     *
     * @param id 身份证
     * @return {@link Dept }
     * @author KM
     * @date 2025/03/04
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门信息
     *
     * @param dept 部门对象
     * @author KM
     * @date 2025/03/04
     */
    // #{name} 、 #{createTime} 、 #{updateTime}均为参数占位符，对应Dept对象中的属性
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
