package com.google.dao.Impl;

import com.google.dao.BookDao;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:31
 * @Description:
 */
public class BookDaoImpl implements BookDao {
    @Override
    public void addBook() {
        System.out.println("bookDao add Book");
    }
}

