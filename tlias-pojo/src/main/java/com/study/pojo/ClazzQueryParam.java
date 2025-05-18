package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 类名称：ClazzQueryParam
 * 描述：查询参数类
 *
 * @author: Lixx
 * 创建时间: 2025/04/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {
    private String name;//班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//结束时间
    private Integer page;//页码
    private Integer pageSize;//每页展示记录数
}
