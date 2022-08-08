package com.google.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/2 07:03
 * @Description: 将"打印时间"这一共性的逻辑抽取出来, 并且把它作为一个通知类, 并且把它注册到AOP中
 */

@Component
@Aspect // 声明这是一个切面类, 并且把它注册到AOP中, 可以把它看做是一个切面类的容器
public class MyAdvice {

    // 定义一个切入点, 即匹配上num()方法的所有调用
    // 接口名.*(..) 匹配接口下所有方法的调用
    // 切入点依托一个不具有实际意义的方法进行,即无返回值,无参数的方法,方法体也没有实际的意义
    //@Pointcut("execution(void com.google.dao.FishDao.*(..))")
    @Pointcut("execution(void com.google.dao.FishDao.price())")
    private void point() {
    }

    /**
     * @Before: 在"切入点"执行前执行
     * 提取通用的逻辑, 就是"通知"的实现
     */
    //@Before("point()")
    public void publicMethod() {
        System.out.println("@Before: 前置通知");
    }

    //@After("point()")
    public void publicMethod1() {
        System.out.println("@After: 后置通知");
    }

    /**
     * @Around: 环绕通知, 在"切入点"执行前后执行,
     * 1.必须要返回一个值(Object类型), 并且这个值就是"目标方法"的返回值
     * 2.声明对原始操作的引用, 并且在环绕通知中使用它
     */
    @Around("point()")
    public Object publicMethod3(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around: 环绕通知, 前");
        // Spring不知道原始操作是否会抛出异常, 所以统一自己抛出异常
        // 不加这个会产生对"原始操作" "隔离"的效果, 即不能让原始操作抛出异常
        Object o = proceedingJoinPoint.proceed();// 调用原始操作
        System.out.println("@Around: 环绕通知, 后");
        return o;
    }

}
