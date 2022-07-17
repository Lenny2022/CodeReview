package com.lenny.MultiTableAnnotation.many_many;

import com.lenny.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 22:36
 * @Description:
 */
public interface CourseMapper {
    //根据学生id查询所选课程
    @Select("SELECT c.id,c.name FROM stu_cr sc,course c WHERE sc.cid=c.id AND sc.sid=#{id}")
    List<Course> selectBySid(Integer id);
}