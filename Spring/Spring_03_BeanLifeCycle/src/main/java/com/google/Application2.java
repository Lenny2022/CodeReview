package com.google;

import com.google.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/7/23 21:17
 * @Description:
 */
public class Application2 {
    public static void main(String[] args) {
        // 3.获取IOC容器,权力转交给IOC,  ctx
        // new 一个ApplicationContext接口的实现类
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // ConfigurableApplicationContext接口registerShutdownHook()方法,关闭注册钩子,关闭容器时调用
        ctx.registerShutdownHook();
        // 4.通过IOC容器来获取bean
        // 直接得到 bookService 对象, 而无需我们去 新new一个
        // bean起别名lenny
        BookService bookService = (BookService) ctx.getBean("lenny");
        bookService.saveBook();

        //此时没有打印出destroy方法, 因为执行完成之后, JVM关闭, 自动销毁,不给这个destroy机会
        // 要想看到destroy方法, 在虚拟机关闭之前, 必须手动关闭, 即使是虚拟机关闭,也要手动关闭
        // 对象换成 ClassPathXmlApplicationContext, ApplicationContext没有此方法
        // ctx.close关闭相对暴力些
        //ctx.close();
    }
}