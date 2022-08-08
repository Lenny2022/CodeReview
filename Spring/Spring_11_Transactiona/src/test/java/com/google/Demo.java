package com.google;

import com.google.config.SpringConfig;
import com.google.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lenny
 * @Date: 2022/8/7 17:08
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class) 是一个运行器,它能够帮我们自动的把我们的测试类加载到IOC容器中
@ContextConfiguration(classes = SpringConfig.class)

public class Demo {

    @Autowired
    private AccountService accountService;

    @Test
    public void TransferTest() {

        accountService.transfer("Jerry", "Tom", 10D);
    }
}
