package com.study.controller;

import com.study.anno.Log;
import com.study.pojo.Dept;
import com.study.pojo.Result;
import com.study.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 类名称：DeptController
 * 描述：部门控制器
 *
 * @author: KM
 * 创建时间: 2025/03/03
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查找全部列表
     * @return {@link Result }
     * @author KM
     * @date 2025/03/03
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET) // method指定请求方式
    @GetMapping
    public Result list() {
        log.info("查询部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList); //返回Result对象
    }

    /**
     * 删除
     *
     * @return {@link Result }
     * @author KM
     * @date 2025/03/03
     */
    @DeleteMapping
    public Result delete(Integer id) {
        /*
        * 请求参数名与形参变量名相同，省略@RequestParam注解
        * delete(Integer id)
        * */
        //System.out.println("删除的部门id：" + id);
        log.info("根据id删除部门, id: {}" , id);
        deptService.deleteById(id);
        return Result.success(); //返回Result对象
    }

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @return {@link Result }
     * @author KM
     * @date 2025/03/04
     */
    @PostMapping
        @Log
    public Result save(@RequestBody Dept dept) {
        //System.out.println("新增的部门信息：" + dept);
        log.info("新增部门, dept: {}" , dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 按 ID 获取部门信息
     *
     * @param id 编号
     * @return {@link Result }
     * @author KM
     * @date 2025/03/04
     */
    @GetMapping("/{id}")
    // @PathVariable注解用于获取路径参数中的变量即{id}，将变量的值赋值给指定的形参，当路径参数中的变量名与形参名一致时@PathVariable注解的value属性可以省略。
    public Result getById(@PathVariable Integer id) {
        //System.out.println("查询的部门id：" + id);
        log.info("根据ID查询, id: {}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 更新部门信息
     *
     * @param dept 部门对象
     * @return {@link Result }
     * @author KM
     * @date 2025/03/04
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        //System.out.println("修改的部门信息：" + dept);
        log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return Result.success();
    }

}
