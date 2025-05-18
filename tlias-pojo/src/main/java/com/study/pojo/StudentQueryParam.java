package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 最高学历, 1: 初中, 2: 高中 , 3: 大专 , 4: 本科 , 5: 硕士 , 6: 博士
     */
    private Integer degree;
    /**
     * 所属班级
     */
    private Integer clazzId;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 每页展示记录数
     */
    private Integer pageSize;
}
