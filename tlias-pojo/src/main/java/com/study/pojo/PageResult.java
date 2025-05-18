package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 类名称：PageResult
 * 描述：分页查询页面结果
 *
 * @author: KM
 * 创建时间: 2025/03/07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total; //总记录数
    private List<T> rows; //当前页数据列表
}
