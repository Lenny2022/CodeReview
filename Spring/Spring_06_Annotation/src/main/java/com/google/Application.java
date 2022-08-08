package com.google;

import com.google.config.SpringConfig;
import com.google.dao.BankDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/7/23 21:17
 * @Description:
 */
public class Application {
    public static void main(String[] args) {
        // 3.获取IOC容器,权力转交给IOC,  ctx
        // new 一个ApplicationContext接口的实现类
        // 如果报错: Caused by: java.lang.IllegalArgumentException: Unsupported class file major version 61,是版本兼容问题,我使用的是jdk17, 可以使用jdk8, 也可以升级spring-context的maven依赖
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfiguration.xml");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 4.通过IOC容器来获取bean

        //BankDao bankDao = (BankDao) ctx.getBean("bankDao");
        // 此时不能通过名称来获取bean, 用类型来获取bean

        // 获取bean的3种方式:
        BankDao bankDao = ctx.getBean(BankDao.class);

        // BankDao bankDao = ctx.getBean("name",BankDao.class);
        // BankDao bankDao = ctx.getBean(name);  @Component("name"), 这时Component注解需要加上name才能匹配到bean
        bankDao.addMoney();
        bankDao.save();

        // 关闭钩子或者关闭资源, 在jvm关闭前调用destroy方法
        ctx.close();


    }
}