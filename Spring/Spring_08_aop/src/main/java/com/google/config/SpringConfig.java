package com.google.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: lenny
 * @Date: 2022/8/2 06:46
 * @Description:
 */

@Configuration
@ComponentScan("com.google")
@EnableAspectJAutoProxy // 启用AOP功能, 相当于启用了SpringConfig里面的@Aspect注解
public class SpringConfig {

}
