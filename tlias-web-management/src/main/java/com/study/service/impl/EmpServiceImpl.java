package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.mapper.EmpExprMapper;
import com.study.mapper.EmpMapper;
import com.study.pojo.*;
import com.study.service.EmpLogService;
import com.study.service.EmpService;
import com.study.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名称：EmpServiceImpl
 * 描述：员工服务实现
 *
 * @author: KM
 * 创建时间: 2025/03/06
 */

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    /*
    原始分页查询
    @Override
    public PageResult<Emp> list(Integer page, Integer pageSize) {
        // TODO: 查询总条数
        Long total  = empMapper.count();

        // TODO: 查询分页数据
        Integer start = (page - 1) * pageSize;
        List<Emp> empList  = empMapper.list(start, pageSize);

        // TODO: 封装数据
        return new PageResult<Emp>(total, empList);
    }
    */

    /**
     * 列表--原始
     *
     * @param page     页码
     * @param pageSize 每页显示数量
     * @param name     名字
     * @param gender   性别
     * @param begin    开始时间
     * @param end      结束时间
     * @return {@link PageResult }<{@link Emp }>
     * @author KM
     * @date 2025/03/09
     */
    /*
    @Override
    public PageResult<Emp> list(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        // TODO: 引入PageHelper分页插件
        PageHelper.startPage(page, pageSize);

        // TODO: 查询分页数据
        List<Emp> empList  = empMapper.list(page, pageSize, name, gender, begin, end);

        // TODO: 封装数据
        Page<Emp> pageObj = (Page<Emp>) empList;
        return new PageResult<Emp>(pageObj.getTotal(), pageObj.getResult());
    }
    */

    /**
     * 列表--优化
     *
     * @param empQueryParam EMP 查询参数
     * @return {@link PageResult }<{@link Emp }>
     * @author KM
     * @date 2025/03/09
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // TODO: 引入PageHelper分页插件
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // TODO: 查询分页数据
        List<Emp> empList  = empMapper.list(empQueryParam);

        // TODO: 封装数据
        Page<Emp> pageObj = (Page<Emp>) empList;
        return new PageResult<Emp>(pageObj.getTotal(), pageObj.getResult());
    }

    /**
     * 新增员工信息
     *
     * @param emp 员工对象信息
     * @author KM
     * @date 2025/03/09
     */
    @Transactional(rollbackFor = Exception.class) // 添加事务注解
    @Override
    public void save(Emp emp) {
        try {
            //TODO: 报错员工基本信息补全信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            //TODO: 保存员工工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                //遍历集合为empId赋值
                exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //TODO: 保存日志信息
            empLogService.insertLog(new EmpLog(null, LocalDateTime.now(), "新增员工信息"));
        }


    }

    /**
     * 删除员工信息
     *
     * @param ids 员工id
     * @author KM
     * @date 2025/03/15
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        //TODO: 根据ID批量删除员工基本信息
        empMapper.deleteById(ids);

        //TODO: 根据员工的ID批量删除员工的工作经历信息
        empExprMapper.deleteByEmpId(ids);

    }

    /**
     * 按 ID 获取员工信息
     *
     * @param id 编号
     * @return {@link Emp }
     * @author Lixx
     * @date 2025/03/15
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 根据id更新员工信息
     *
     * @param emp 员工对象
     * @author Lixx
     * @date 2025/03/16
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        //TODO: 根据id更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);


        //TODO: 根据id更新员工工作经历信息
        // TODO: 删除员工工作经历信息
        empExprMapper.deleteByEmpId(Arrays.asList(emp.getId()));

        // TODO: 添加员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            //遍历集合为empId赋值
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * 登录
     *
     * @param emp 用户对象
     * @return {@link LoginInfo }
     * @author Lixx
     * @date 2025/03/18
     */

    @Override
    public LoginInfo login(Emp emp) {
        //TODO: 根据用户名查询用户信息
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);

        // TODO: 判断信息是否为空，如果不为空，则组装登录信息并返回
        if (loginEmp != null) {
            // TODO: 获取token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("username", loginEmp.getUsername());

            String token = JwtUtils.createToken(claims);
            LoginInfo loginInfo = new LoginInfo(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(), token);
            return loginInfo;
        }

        // TODO: 如果为空，则返回null
        return null;
    }

    @Override
    public List<Emp> list() {
        return empMapper.findAll();
    }
}
