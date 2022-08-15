package com.google.service.impl;

import com.google.DO.Student;
import com.google.dao.StuDao;
import com.google.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lenny
 * @Date: 2022/8/9 23:03
 * @Description:
 */

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDao stuDao;

    @Override
    public boolean save(String name, Integer age) {

        Student stu = new Student(null,name, age);

        int insert = stuDao.insert(stu);

        // 通过判断insert的值来判断是否插入成功,如果插入成功,insert的值为1,如果插入失败,insert的值为0
        return (insert != 0);
    }
}
