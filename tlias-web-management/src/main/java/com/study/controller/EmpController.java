package com.study.controller;

import com.study.pojo.Emp;
import com.study.pojo.EmpQueryParam;
import com.study.pojo.PageResult;
import com.study.pojo.Result;
import com.study.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类名称：EmpController
 * 描述：员工数据控制器
 *
 * @author: KM
 * 创建时间: 2025/03/06
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询--原始
     *
     * @param page     页码
     * @param pageSize 每页显示数量
     * @param name     名字
     * @param gender   性别
     * @param begin    开始时间
     * @param end      结束时间
     * @return {@link Result }
     * @author KM
     * @date 2025/03/07
     */
    /*
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam (defaultValue = "10") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageResult<Emp> pageResult = empService.list(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }
    */

    /**
     * 分页查询--优化
     *
     * @param empQueryParam EMP 查询参数
     * @return {@link Result }
     * @author KM
     * @date 2025/03/07
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询，参数：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增员工
     *
     * @param emp 员工对象
     * @return {@link Result }
     * @author KM
     * @date 2025/03/10
     */

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工，数据：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除--删除的id封装在数组中
     *
     * @param ids 删除的id数组
     * @return {@link Result }
     * @author KM
     * @date 2025/03/15
     *
     *public Result delete( Integer[] ids) {
     *    log.info("批量删除员工，id：{}", Arrays.toString(ids));
     *    return Result.success();
     *}
     */

    /**
     * 删除--删除的id封装在List集合中
     *
     * @param ids 删除的id集合
     * @return {@link Result }
     * @author KM
     * @date 2025/03/15
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工，id：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 按 ID 获取员工信息
     *
     * @param id 编号
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/15
     */

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询员工信息，id：{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 根据id更新员工信息
     *
     * @param emp 员工对象
     * @return {@link Result }
     * @author Lixx
     * @date 2025/03/16
     */

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工信息，数据：{}", emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list() {
        log.info("查询所有员工");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }

}
