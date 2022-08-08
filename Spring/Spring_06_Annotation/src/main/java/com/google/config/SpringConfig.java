package com.google.config;

import com.google.jdbcConfig.DataSourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: lenny
 * @Date: 2022/7/27 00:09
 * @Description:
 */

@Configuration  // 该注解表示该类是一个配置类, 可以被spring容器扫描到
@ComponentScan("com.google") // 该注解表示该类扫描的包路径, 可以被spring容器扫描到,多个包路径用逗号隔开
//@ComponentScan({"com.google.dao", "com.google.service"}) // 该注解表示该类扫描的包路径, 可以被spring容器扫描到,多个包路径用逗号隔开
// @ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中, 就是装配了@Component 和其它衍生的注解的类
@PropertySource("abc.properties")  // 加载外部配置文件, 可以被spring容器扫描到,多个包路径用逗号隔开
@Import(DataSourceConfig.class)  // 加载外部配置文件, 可以被spring容器扫描到,多个包路径用逗号隔开
public class SpringConfig {
}
