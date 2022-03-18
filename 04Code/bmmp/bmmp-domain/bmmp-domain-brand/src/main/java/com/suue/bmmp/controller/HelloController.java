package com.suue.bmmp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * Created by shuds on 2022/3/1
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World.";
    }

}
