package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-boot-part4
 * @package: com.learn.springboot.controller
 * @classname: TestController
 * @description:
 * @author: zbb
 * @create: 2022-02-18
 */
@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String testIndex(){
        return "test index";
    }
}
