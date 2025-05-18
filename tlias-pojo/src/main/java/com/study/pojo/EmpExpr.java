package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 类名称：EmpExpr
 * 描述：工作经历实体类
 *
 * @author: KM
 * 创建时间: 2025/03/06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位
}
