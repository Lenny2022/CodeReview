package com.google.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lenny
 * @Date: 2022/8/9 00:21
 * @Description: springmvc配置类,本质上还是一个spring配置类,只不过是一个扫描的配置类
 */

@Configuration
@ComponentScan("com.google.controller")
public class SpringMvcConfig {

}
