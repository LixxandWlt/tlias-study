package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 类名称：EmpLog
 * 描述：EMP 员工日志记录实体类
 *
 * @author: KM
 * 创建时间: 2025/03/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpLog {
    private Integer id;//ID
    private LocalDateTime operateTime; //操作时间
    private String info;//详细信息
}
