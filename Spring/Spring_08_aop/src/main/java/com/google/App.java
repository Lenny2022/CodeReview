package com.google;

import com.google.config.SpringConfig;
import com.google.dao.FishDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/8/2 06:53
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        FishDao fishDao = ctx.getBean(FishDao.class);

        /*
            AOP: 判断bean对应类中的方法是否匹配到任意的切入点
                1. 匹配失败: 创建对象
                   class com.google.dao.Impl.FishDaoImpl
                2. 匹配成功: 创建"目标对象"的'代理'对象, 并且调用目标对象的方法
                   class jdk.proxy2.$Proxy19
         */
        //System.out.println(fishDao.getClass());

        // 测试AOP的"通知类型"
        fishDao.price();
    }
}
