package com.study.controller;

import com.study.pojo.*;
import com.study.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类名称：ClazzContorller
 * 描述：Clazz contorller
 *
 * @author: Lixx
 * 创建时间: 2025/04/22
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzContorller {
    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询列表
     *
     * @param clazzQueryParam
     * @return {@link Result }
     * @author Lixx
     * @date 2025/04/24
     */

    @GetMapping
    private Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询，参数：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 保存
     * @param clazz 班级对象
     * @return {@link Result }
     * @author Lixx
     * @date 2025/04/27
     */

    @PostMapping
    private Result save(@RequestBody Clazz clazz){
        log.info("保存班级，参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 按 ID 查找
     *
     * @param id 身份证
     * @return {@link Result }
     * @author Lixx
     * @date 2025/04/28
     */

    @GetMapping("/{id}")
    private Result findById(@PathVariable Integer id){
        log.info("根据id查询班级，id：{}", id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    /**
     * 更新
     *
     * @param clazz 班级对象
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/06
     */

    @PutMapping
    private Result update(@RequestBody Clazz clazz){
        log.info("更新班级，参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/07
     */

    @DeleteMapping("/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除班级，id：{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 查找全部
     *
     * @return {@link Result }
     * @author Lixx
     * @date 2025/04/27
     */

    @GetMapping("/list")
    private Result findAll(){
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }
}
