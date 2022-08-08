package com.google.dao.Impl;

import com.google.dao.BankDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:31
 * @Description:
 */
//@Component // 最基础的注解, 表示该类是一个bean, 可以被注入到spring容器中进行管理使用
@Repository
//@Scope("prototype") // 表示该类的作用域是prototype, 即每次调用new的时候都会创建一个新的对象, 如果是singleton, 则只会创建一个对象, 并且每次调用都会返回同一个对象
public class BankDaoImpl implements BankDao {

    // 使用@PostConstruct、@PreDestroy定义bean生命周期

    @Override
    public void save() {
        System.out.println("bankDao save");
    }

    @Override
    public void addMoney() {
        System.out.println("bank dao add money ...");
    }

    @PostConstruct  //java自己的注解, 需要单独引入maven依赖, 可以在类上加上该注解, 在实例化对象的时候会自动调用该方法
    public void init() {
        System.out.println("bank dao init ...");
    }

    // 销毁方法, 在容器销毁bean的时候会自动调用该方法
    @PreDestroy
    public void destroy() {
        System.out.println("bank dao destroy ...");
    }


}

