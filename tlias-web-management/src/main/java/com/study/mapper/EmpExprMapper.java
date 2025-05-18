package com.study.mapper;

import com.study.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 插入批处理
     *
     * @param exprList 工作经历对象
     * @author KM
     * @date 2025/03/10
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 按员工id批量删除
     *
     * @param empIds 员工id
     * @author Lixx
     * @date 2025/03/15
     */
    void deleteByEmpId(List<Integer> empIds);
}
