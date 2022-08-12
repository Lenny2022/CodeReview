package com.google.dao;

import com.google.DO.Student;
import org.apache.ibatis.annotations.Insert;

/**
 * @author: lenny
 * @Date: 2022/8/9 23:04
 * @Description:
 */
public interface StuDao {

    @Insert("insert into stu(name,age) values(#{name},#{age})")
    int insert(Student stu);
}
