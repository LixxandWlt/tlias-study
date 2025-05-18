package com.study.service;

import com.study.pojo.Emp;
import com.study.pojo.EmpQueryParam;
import com.study.pojo.LoginInfo;
import com.study.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 类名称：EmpService
 * 描述：员工服务
 *
 * @author: KM
 * 创建时间: 2025/03/06
 */

public interface EmpService {
    /**
     * 分页查询列表--原始
     *
     * @param page     页码
     * @param pageSize 每页数量
     * @param name     名字
     * @param gender   性
     * @param begin    开始时间
     * @param end      结束时间
     * @return {@link PageResult }<{@link Emp }>
     * @author KM
     * @date 2025/03/07
     */
    //PageResult<Emp> list(Integer page, Integer pageSize,String name, Integer gender,LocalDate begin,LocalDate end);

    /**
     * 分页查询列表--优化
     *
     * @param empQueryParam EMP 查询参数
     * @return {@link PageResult }<{@link Emp }>
     * @author KM
     * @date 2025/03/07
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     * @param emp 员工对象信息
     * @author KM
     * @date 2025/03/09
     */
    void save(Emp emp);

    /**
     * 删除员工信息
     *
     * @param ids 用户id
     * @author KM
     * @date 2025/03/15
     */

    void delete(List<Integer> ids);

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
     * 根据id更新员工信息
     *
     * @param emp 员工对象
     * @author Lixx
     * @date 2025/03/16
     */
    void update(Emp emp);

    /**
     * 登录
     *
     * @param emp 用户对象
     * @return {@link LoginInfo }
     * @author Lixx
     * @date 2025/03/18
     */

    LoginInfo login(Emp emp);

    List<Emp> list();
}
