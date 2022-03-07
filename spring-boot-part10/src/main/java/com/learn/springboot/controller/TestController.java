package com.learn.springboot.controller;

import com.learn.springboot.exception.GlobalException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test() throws  Exception{
       int a=1/0;
       return "test";
    }

    @GetMapping("/testexception")
    public String testexception() throws GlobalException {
        throw new GlobalException("发生错误2");
    }
}
