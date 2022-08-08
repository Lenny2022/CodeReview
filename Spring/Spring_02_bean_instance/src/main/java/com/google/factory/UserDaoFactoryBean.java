package com.google.factory;

import com.google.dao.Impl.UserDaoImpl;
import com.google.dao.UserDao;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: lenny
 * @Date: 2022/7/24 06:44
 * @Description: 实例工厂方法2.0版本
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        System.out.println("FactoryBean UserDao getObject()");
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("FactoryBean UserDao getObjectType()");
        return UserDao.class;
    }

    /**
     * 如果是单例的话,返回true,如果是多例的话,返回false. 默认是true
     * @return
     */
    @Override
    public boolean isSingleton() {
        //return FactoryBean.super.isSingleton(); true
        return false;
    }
}
