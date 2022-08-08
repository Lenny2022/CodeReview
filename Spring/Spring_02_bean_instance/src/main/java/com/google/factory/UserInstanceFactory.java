package com.google.factory;

import com.google.dao.Impl.StuDaoImpl;
import com.google.dao.Impl.UserDaoImpl;
import com.google.dao.StuDao;
import com.google.dao.UserDao;

/**
 * @author: lenny
 * @Date: 2022/7/24 05:20
 * @Description: 静态工厂类造对象, 早起常见的方法,(兼容早期系统)
 */
public class UserInstanceFactory {
    public UserDao getUserDao() {
        System.out.println("UserInstanceFactory '实例'工厂....test");
        return new UserDaoImpl();
    }
}
