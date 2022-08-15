package com.google.controller;

import com.google.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: lenny
 * @Date: 2022/8/9 00:13
 * @Description: 创建一个控制器类
 */

@Controller
@Slf4j
@RequestMapping("/user")
public class StuController {

    @Autowired
    private StuService stuService;

    // RequestMapping : produces : 返回的数据类型,内部指定 MessageConverter 返回的数据类型

    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertStu(String name, Integer age) {

        System.out.println("name:" + name + ", age:" + age);

        log.info("name:{},age:{}", name, age);

        // boolean result = stuService.save(name, age);
        //
        // try {
        //     if (result) {
        //         return ResponseEntity.ok("success");
        //     }
        // } catch (Exception e) {
        //     log.error("插入Student表失败！", e);
        // }

        // return ResponseEntity.badRequest().body("fail");

        return "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";

    }
}

