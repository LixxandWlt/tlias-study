package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 类名称：JobOption
 * 描述：统计结果实体类
 *
 * @author: Lixx
 * 创建时间: 2025/03/16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    private List jobList;
    private List dataList;
}
