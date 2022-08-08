package com.google.dao;

import com.google.DO.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/29 07:53
 * @Description: Spring整合MyBatis, 注解开发
 */


public interface PersonDao {

    @Insert("insert into person (id,NAME,age) values (#{id},#{name},#{age})")
    void insert(Person person);

    @Update("update person set name=#{name},age=#{age} where id=#{id}")
    void update(Person person);

    @Delete("delete from person where id=#{id}")
    void delete(Integer id);

    @Select("select * from person where id=#{id}")
    Person selectById(Integer id);

    @Select("select * from person ")
    List<Person> selectAll();
}
