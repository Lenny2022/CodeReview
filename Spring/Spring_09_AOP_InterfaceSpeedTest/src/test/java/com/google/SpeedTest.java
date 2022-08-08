package com.google;


import com.google.DO.Person;
import com.google.service.PersonService;
import com.google.config.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/29 08:28
 * @Description: Spring整合Junit测试
 */


@RunWith(SpringJUnit4ClassRunner.class)     // Spring类运行器
@ContextConfiguration(classes = SpringConfig.class) // 指定Spring的配置类
public class SpeedTest {

    @Autowired
    private PersonService personService;

    @Test
    public void Demo1() {

        // 打印,遍历
        List<Person> people = personService.selectAll();
    }

    @Test
    public void Demo2() {

        Person person = personService.selectById(1);

    }
}
