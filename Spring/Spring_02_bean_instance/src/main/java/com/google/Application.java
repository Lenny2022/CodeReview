package com.google;

import com.google.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/7/23 20:36
 * @Description: 非Spring环境
 */
public class Application {
    public static void main(String[] args) {
        // 3.获取IOC容器,权力转交给IOC,  ctx
        // new 一个ApplicationContext接口的实现类
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 4.通过IOC容器来获取bean
        // 直接得到 bookService 对象, 而无需我们去 新new一个
        // bean起别名lenny
        BookDao bookDao = (BookDao) ctx.getBean("lennyBook");
        bookDao.add();
    }
}
