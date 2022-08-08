package com.google.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: lenny
 * @Date: 2022/7/29 07:48
 * @Description:
 */

@Configuration
@ComponentScan("com.google")
@Import({JdbcConfig.class,MyBatisConfig.class})
// 这里的配置一定都要导入
@PropertySource("jdbc.properties")
public class SpringConfig {

}
