package com.google.dao.Impl;

import com.google.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:31
 * @Description:
 */

@Service("bookDao2")  // 配合@Qualifier("bookDao2")使用
public class BookDaoImpl implements BookDao {

    @Value("${password}")
    private String password;

    @Override
    public void addBook() {
        System.out.println("bookDao add Book");

        System.out.println("password: " + password);
    }
}

