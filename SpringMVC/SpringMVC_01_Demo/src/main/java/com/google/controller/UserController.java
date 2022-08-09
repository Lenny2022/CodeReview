package com.google.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: lenny
 * @Date: 2022/8/9 00:13
 * @Description: 创建一个控制器类
 */

@Controller
public class UserController {

    @RequestMapping("/speak")
    @ResponseBody
    public String user() {
        System.out.println("简单测试一下springmvc,阿里OceanBase");
        return "{user : 'lenny'}";
    }
}
