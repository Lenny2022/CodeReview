package com.google.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author: lenny
 * @Date: 2022/8/3 21:18
 * @Description:
 */

@Aspect
@Component
public class PswAdvice {

    // 1.定义切入点
    //@Pointcut("execution(* com.google.service.PswService.openUrl(..))")
    @Pointcut("execution(boolean com.google.service.*Service.*(..))")   //匹配接口下的所有
    public void pswPointcut() {
    }

    @Around("pswPointcut()")
    public Object checkPassword(ProceedingJoinPoint pcj) throws Throwable {
        // 1.拿到这个密码,进行处理,使其通过校验
        Object[] args = pcj.getArgs();
        for (Object arg : args) {
            int length = arg.toString().length();
            System.out.println("处理前长度" + length);
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].getClass().equals(String.class)) {
                // tirm() 去除字符串前后的空格,
                args[i] = args[i].toString().trim();
            }
        }

        //for (Object arg : args) {
        //    int length = arg.toString().length();
        //    System.out.println("处理前后长度" + length);
        //}

        
        Arrays.stream(args).forEach(a -> {
            System.out.println("处理后长度" + a.toString().length());
        });

        // 此处要传入args参数, 不传入的话,还是原始的参数,不会被替换
        return pcj.proceed(args);
    }
}
