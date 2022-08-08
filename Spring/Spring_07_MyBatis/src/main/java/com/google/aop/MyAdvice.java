package com.google.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/3 18:34
 * @Description:
 */

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.google.service.PersonService.selectAll())")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object speedTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("myAdvice.speedTest()");

        proceedingJoinPoint.proceed();

        System.out.println("myAdvice.speedTest() end");

        return null;
    }

}
