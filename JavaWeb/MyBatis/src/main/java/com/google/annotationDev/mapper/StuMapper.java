package com.google.annotationDev.mapper;

import com.google.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/3 16:59
 * @Description:
 */
public interface StuMapper {
    /**
     * 查询所有学生集合
     *
     * @return list集合
     */
    @Select("select * from student")
    List<Student> selectAll();

    /**
     * 新增
     *
     * @param student
     * @return
     */
    @Insert("INSERT INTO student(id, NAME ,age) VALUES (#{id}, #{name}, #{age}) ")
    Integer insert(Student student);

    /**
     * 删除
     */
    @Delete("delete from student where id = #{id}")
    Integer delete(Integer id);


    /**
     * 修改
     *
     * @param student
     * @return
     */
    @Update("update student set name = #{name} where id = #{id}")
    Integer update(Student student);

    /**
     * 通过id或者name查询
     *
     * @return Discription: id和name的数据类型不一致,所以需要加上@Param注解, 一致的话可以不加(单个)
     * @Param 参数对应#{id}或者#{name}
     */
    @Select("select * from student where id = #{p1} or name = #{p2}")
    List<Student> selectByIdOrName(@Param("p1") Integer id, @Param("p2") String name);
}
