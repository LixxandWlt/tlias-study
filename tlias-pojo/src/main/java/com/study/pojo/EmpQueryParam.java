package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 类名称：EmpQueryParam
 * 描述：查询参数类
 *
 * @author: KM
 * 创建时间: 2025/03/09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
    private String name;//姓名
    private Integer gender;//性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//入职开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//入职结束时间
    private Integer page;//页码
    private Integer pageSize;//每页展示记录数
}
