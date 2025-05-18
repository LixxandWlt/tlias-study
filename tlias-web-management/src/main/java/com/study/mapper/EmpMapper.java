package com.study.mapper;

import com.study.pojo.Emp;
import com.study.pojo.EmpQueryParam;
import com.study.pojo.PageResult;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 类名称：EmpMapper
 * 描述：员工数据持久层接口
 *
 * @author: KM
 * 创建时间: 2025/03/06
 */

@Mapper
public interface EmpMapper {
    /*原始分页*/
    /**
     * 查询总记录数
     *
     * @return {@link Long }
     * @author KM
     * @date 2025/03/07
     *
     * 代码
     *  @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
     *     Long count();
     */
    /**
     * 分页查询列表
     *
     * @param start  开始
     * @param pageSize 页面大小
     * @return {@link List}<{@link Emp}>员工对象列表
     * @author KM
     * @date 2025/03/07
     *
     * 代码
     * @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
     *         "order by e.update_time desc limit #{start}, #{pageSize}")
     * List<Emp> list(Integer start , Integer pageSize);
     */

    /*使用PageHelper分页插件*/
    /**
     * 分页查询列表--原始
     *
     * @param page     页码
     * @param pageSize 每页显示数量
     * @param name     名字
     * @param gender   性别
     * @param begin    开始时间
     * @param end      结束时间
     * @return {@link List}<{@link Emp}>员工对象列表
     * @author KM
     * @date 2025/03/07
     */
    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    //List<Emp> list(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 分页查询列表--优化
     *
     * @param empQueryParam EMP 查询参数
     * @return {@link List}<{@link Emp}>员工对象列表
     * @author KM
     * @date 2025/03/07
     */
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 插入
     *
     * @param emp 员工对象
     * @author KM
     * @date 2025/03/10
     */
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    //@Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
    //        "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 按 ID 批量删除基本信息
     *
     * @param ids 员工id
     * @author Lixx
     * @date 2025/03/15
     */
    void deleteById(List<Integer> ids);

    /**
     * 按 ID 获取员工信息
     *
     * @param id 编号
     * @return {@link Emp }
     * @author Lixx
     * @date 2025/03/15
     */
    Emp getById(Integer id);

    /**
     * 按 ID 更新
     *
     * @param emp 员工对象
     * @author Lixx
     * @date 2025/03/16
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>> 职位员工人数
     * @author Lixx
     * @date 2025/03/17
     */
    @MapKey("job")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计性别数
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/03/17
     */
    @MapKey("name")
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 通过用户名和密码查询用户信息
     *
     * @param emp 用户对象
     * @return {@link Emp }
     * @author Lixx
     * @date 2025/03/18
     */

    Emp getByUsernameAndPassword(Emp emp);

    List<Emp> findAll();
}
