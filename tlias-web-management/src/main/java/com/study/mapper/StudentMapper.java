package com.study.mapper;

import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 按班级id计算学生人数
     *
     * @param id 身份证
     * @return {@link Integer }
     * @author Lixx
     * @date 2025/05/09
     */
    Integer countStudentByClazzId(Integer id);

    /**
     * 分页查询
     *
     * @param studentQueryParam student 查询参数
     * @return {@link List }<{@link Student }>
     * @author Lixx
     * @date 2025/05/09
     */

    List<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 新增学生
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    void save(Student student);

    /**
     * 按 ID 查找
     *
     * @param id id
     * @return {@link Student }
     * @author Lixx
     * @date 2025/05/09
     */

    Student getById(Integer id);

    /**
     * 更新
     *
     * @param student 学生对象
     * @author Lixx
     * @date 2025/05/09
     */

    void update(Student student);

    /**
     * 按 ID 批量删除
     *
     * @param ids IDS
     * @author Lixx
     * @date 2025/05/09
     */

    void deleteByIds(List<Integer> ids);

    void violation(Integer id, Integer score);

    /**
     * 获取学生学历数据
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/05/11
     */
    @MapKey("name")
    List<Map<String, Object>> getStudentDegreeData();

    /**
     * 班级人数统计
     *
     * @return {@link List }<{@link Map }<{@link String }, {@link Object }>>
     * @author Lixx
     * @date 2025/05/11
     */
    List<Map<String, Object>> countEmpJobData();
}
