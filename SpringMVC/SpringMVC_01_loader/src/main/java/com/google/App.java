package com.google;

import com.google.config.SpringConfig;
import com.google.controller.StuController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/8/10 00:14
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 测试SpringMvc的bean是否可以被Spring容器扫描到. 通过SpringMvcConfig扫描到了
        StuController bean = ctx.getBean(StuController.class);

        System.out.println(bean.getClass());
    }
}
