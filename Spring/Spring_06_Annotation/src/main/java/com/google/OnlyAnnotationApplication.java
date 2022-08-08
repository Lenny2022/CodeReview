package com.google;

import com.google.config.SpringConfig;
import com.google.dao.BankDao;
import com.google.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author: lenny
 * @Date: 2022/7/23 21:17
 * @Description:
 */
public class OnlyAnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        //System.out.println(ctx.getBean(BankDao.class));

        //BookService bookService = ctx.getBean(BookService.class);
        //
        //bookService.saveBook();

        DataSource dataSource = ctx.getBean(DataSource.class);

        System.out.println(dataSource);
    }
}