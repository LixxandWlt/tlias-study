package com.study.controller;

import com.study.pojo.PageResult;
import com.study.pojo.Result;
import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;
import com.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询
     *
     * @param studentQueryParam student 查询参数
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/08
     */

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询，参数：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);

    }

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/09
     */

    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学生，参数：{}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 按 ID 查找
     *
     * @param id id
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/09
     */

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工信息，id：{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 更新
     *
     * @param student 学生对象
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/09
     */

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新员工信息，数据：{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除
     *
     * @param ids IDS
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/09
     */

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除员工，id：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 违纪扣分
     *
     * @param id    身份证
     * @param score 分数
     * @return {@link Result }
     * @author Lixx
     * @date 2025/05/11
     */

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("扣分，id：{}，score：{}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }
}
