package com.google.factory;

import com.google.dao.Impl.StuDaoImpl;
import com.google.dao.StuDao;

/**
 * @author: lenny
 * @Date: 2022/7/24 05:20
 * @Description: 静态工厂类造对象, 早起常见的方法,(兼容早期系统)
 */
public class StuStaticFactory {
    public static StuDao getStuDao() {
        System.out.println("StuStaticFactory 静态工厂....test");
        return new StuDaoImpl();
    }
}
