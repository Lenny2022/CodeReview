package com.google.service.Impl;

import com.google.dao.BookDao;
import com.google.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:33
 * @Description:
 */

@Service
public class BookServiceImpl implements BookService {

    // 此时BookService依赖BookDao, 如何处理 ?
    // 可以借助于DI, 由IOC容器来进行注入
    //private final BookDao bookDao = new BookDaoImpl();


    @Autowired
    @Qualifier("bookDao2")
    // @Qualifier : 指定注入的bean的名称, 如果有多个同类型的bean, 可以指定注入的bean的名称, 如果没有指定, 默认会注入第一个bean
    private BookDao bookDao;

    //删除 new ...  , 提供对应的get,set方法
    //public void setBookDao(BookDao bookDao) {
    //    this.bookDao = bookDao;
    //}

    @Override
    public void saveBook() {
        System.out.println("BookService saveBook");
        bookDao.addBook();
    }
}
