package com.google.dao.Impl;

import com.google.dao.BookDao;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:31
 * @Description:
 */
public class BookDaoImpl implements BookDao {

    private String bookList;
    private int bookPrice;

    public void setBookList(String bookList) {
        this.bookList = bookList;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public void addBook() {
        System.out.println("bookDao add Book");
        System.out.println("setter注入: bookList: " + bookList+"bookPrice: " + bookPrice);
    }

    //1.定义两个方法, 分别用于初始化和销毁, 2. 在配置文件中配置

    public void init() {
        System.out.println("bookDao init");
    }

    public void destroy() {
        System.out.println("bookDao destroy");
    }


}

