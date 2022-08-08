package com.google.dao.Impl;

import com.google.dao.BookDao;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:31
 * @Description:
 */
public class BookDaoImpl implements BookDao {


    /**
     * 构造方法: bean的第1种实例化方式
     * 空参构造
     * private也可以, 说明内部用到了"反射"
     * Spring 创建对象 默认使用"空参构造"
     */
    public BookDaoImpl() {
        System.out.println("bookDao construct is running..");
    }

    @Override
    public void add() {
        System.out.println("bookDao add ...");
    }
}

