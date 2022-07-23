package com.google.service.Impl;

import com.google.dao.BookDao;
import com.google.service.BookService;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:33
 * @Description:
 */
public class BookServiceImpl implements BookService {

    // 此时BookService依赖BookDao, 如何处理 ?
    // 可以借助于DI, 由IOC容器来进行注入
    //private final BookDao bookDao = new BookDaoImpl();


    private BookDao bookDao;

    //删除 new ...  , 提供对应的get,set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void saveBook() {
        System.out.println("BookService saveBook");
        bookDao.addBook();
    }
}
