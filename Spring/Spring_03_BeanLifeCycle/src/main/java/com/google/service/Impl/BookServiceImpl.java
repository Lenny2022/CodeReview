package com.google.service.Impl;

import com.google.dao.BookDao;
import com.google.dao.Impl.BookDaoImpl;
import com.google.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.w3c.dom.ls.LSOutput;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:33
 * @Description: 2.接口形式来实现bean的生命周期
 */
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {

    // 此时BookService依赖BookDao, 如何处理 ?
    // 可以借助于DI, 由IOC容器来进行注入
    //private final BookDao bookDao = new BookDaoImpl();


    private BookDao bookDao;
    private final String bookName;

    public BookServiceImpl(BookDao bookDao, String bookName) {
        this.bookDao = bookDao;
        this.bookName = bookName;
    }

    //删除 new ...  , 提供对应的get,set方法
    public void setBookDao(BookDao bookDao) {
        System.out.println("属性设置好之后,才到afterPropertiesSet方法中");
        this.bookDao = bookDao;
    }

    @Override
    public void saveBook() {
        System.out.println("BookService saveBook");
        System.out.println("构造器注入简单类型: bookName: " + bookName);
        bookDao.addBook();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BookService destroy");
    }

    /**
     * afterPropertiesSet 在属性设置完成后调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BookService init");
    }
}
