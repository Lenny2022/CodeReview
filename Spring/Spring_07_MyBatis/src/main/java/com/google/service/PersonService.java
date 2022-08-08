package com.google.service;

import com.google.DO.Person;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/29 08:08
 * @Description:
 */
public interface PersonService {

    void insert(Person person);

    void update(Person person);

    void delete(Integer id);

    Person selectById(Integer id);

    List<Person> selectAll();
}
