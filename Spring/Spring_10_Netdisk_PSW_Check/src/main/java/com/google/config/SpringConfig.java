package com.google.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: lenny
 * @Date: 2022/8/3 21:00
 * @Description:
 */

@Configuration
@ComponentScan("com.google")
@EnableAspectJAutoProxy
public class SpringConfig {
}
