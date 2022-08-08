package com.google.service.Impl;

import com.google.DO.Person;
import com.google.service.PersonService;
import com.google.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/29 08:01
 * @Description:
 */

@Service
// 这里@Service注解的意思是，将这个类的对象注入到spring容器中，这样spring容器就可以自动获取到这个类的对象了。
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void insert(Person person) {
        personDao.insert(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public void delete(Integer id) {
        personDao.delete(id);
    }

    @Override
    public Person selectById(Integer id) {
        return personDao.selectById(id);
    }

    @Override
    public List<Person> selectAll() {
        return personDao.selectAll();
    }
}
