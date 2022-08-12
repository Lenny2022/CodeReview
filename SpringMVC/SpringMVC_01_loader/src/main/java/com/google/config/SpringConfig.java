package com.google.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author: lenny
 * @Date: 2022/8/9 22:40
 * @Description:
 */

@Configuration
// Spring的bean要和SpringMvc的bean区分开,两种方式:1,Spring @ComponentScan 时候缩小范围, 2,排除掉SpringMvc的, 也是常见的做法(SpringBoot底层也用到这种)
@ComponentScan({"com.google.service","com.google.dao"})

// 指定扫描的范围,排除掉SpringMvc的,也是常见的做法(SpringBoot底层也用到这种)
// @ComponentScan(value = "com.google",
//         excludeFilters = {@ComponentScan.Filter(
//                 type = FilterType.ANNOTATION,classes = Controller.class)})

@Import({JdbcConfig.class, MyBatisConfig.class})
// 这里的配置一定都要导入
@PropertySource("jdbc.properties")
public class SpringConfig {
}
