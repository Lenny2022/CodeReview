package com.google;


import com.google.config.SpringConfig;
import com.google.service.PersonService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lenny
 * @Date: 2022/7/29 08:28
 * @Description: Spring整合Junit测试
 */

@RunWith(SpringJUnit4ClassRunner.class)     // Spring类运行器
@ContextConfiguration(classes = SpringConfig.class) // 指定Spring的配置类
public class Test {

    @Autowired
    private PersonService personService;

    @org.junit.Test
    public void Demo1() {
        // 打印,遍历
        personService.selectAll();

    }

}
