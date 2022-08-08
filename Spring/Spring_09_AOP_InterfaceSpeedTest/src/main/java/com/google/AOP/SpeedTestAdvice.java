package com.google.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/3 17:53
 * @Description:
 */

@Aspect
@Component
@Slf4j
public class SpeedTestAdvice {

    // 1.定义切入点,匹配业务层所有的方法
    @Pointcut("execution(* com.google.service.PersonService.selectAll())")
    public void pointcut() {
    }

    // 2.定义通知,打印方法执行时间
    @Around("pointcut()")
    public void speedTest(ProceedingJoinPoint pjp) throws Throwable {

        // 1,通过获取到的pjp的签名,获取到方法的参数值
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();


        long startTime = System.currentTimeMillis();

        int num = 1000;
        for (int i = 0; i < num; i++) {
            pjp.proceed();
        }

        long endTime = System.currentTimeMillis();

        log.info(className + '.' + methodName+ ": " + num + " 次执行时间: " + "---> " + (endTime - startTime) + "ms");

    }

}

