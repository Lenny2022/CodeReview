package com.lenny.MultiTableAnnotation.many_many;

import com.lenny.bean.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 22:17
 * @Description:
 */
public interface StudentMapper {
    /**
     * 根据cid查询student表
     *
     * @return
     */
    @Select("SELECT DISTINCT s.id,s.name,s.age FROM student s,stu_cr sc WHERE sc.sid=s.id")
    @Results({
                    @Result(column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "age", property = "age"),
                    @Result(property = "courses",
                            column = "id",  //classes表的外键 id作为条件，关联student表的id
                            javaType = List.class,
                            many = @Many(select = "com.lenny.MultiTableAnnotation.many_many.CourseMapper.selectBySid")
                    )}
    )
    List<Student> selectAll();
}
