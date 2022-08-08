package com.google;

import com.google.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:36
 * @Description: 非Spring环境
 */
public class Application2 {
    public static void main(String[] args) {
        // 1. 静态工厂类造对象,
        // 原始
        //StuDao stuDao = StuStaticFactory.getStuDao();
        //stuDao.add();

        // 2.借助Spring,静态工厂类造对象
        // 2.1 修改配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //StuDao stuDao = (StuDao)ctx.getBean("stuDao");
        //
        //stuDao.add();

        // 3. "实例"工厂创建bean(非静态)
        // 非静态,通过对象调用方法
        //UserInstanceFactory userInstanceFactory = new UserInstanceFactory();
        //UserDao userDao = userInstanceFactory.getUserDao();
        //userDao.add();

        // 3.1 通过Spring调用工厂来实现
        UserDao userDao1 = (UserDao) ctx.getBean("userDao");
        UserDao userDao2 = (UserDao) ctx.getBean("userDao");

        if (userDao1 == userDao2) {
            System.out.println("默认: 单例模式");
        } else {
            System.out.println("isSingleton 返回值改为'false',多例模式");
        }
        //userDao.add();

    }
}
