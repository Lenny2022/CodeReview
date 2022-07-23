package com.google;

import com.google.service.Impl.BookServiceImpl;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:36
 * @Description: 非Spring环境
 */
public class Application {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.saveBook();
    }
}
