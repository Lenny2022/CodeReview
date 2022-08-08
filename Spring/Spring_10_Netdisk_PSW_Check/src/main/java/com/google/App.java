package com.google;

import com.google.config.SpringConfig;
import com.google.service.PswService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/8/3 20:47
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        // AOP模拟密码空格检查
        String password = "  1234         ";
        //String url = "http://www.baidu.com";


        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        PswService pswService = ctx.getBean(PswService.class);

        boolean result = pswService.openUrl( password);

        if (result) {
            System.out.println("密码校验通过");
        } else {
            System.out.println("密码校验失败");
        }
    }
}
