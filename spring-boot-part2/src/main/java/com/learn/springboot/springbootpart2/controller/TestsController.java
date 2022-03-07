package com.learn.springboot.springbootpart2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-part2
 * @package: com.learn.springboot.springbootpart2.controller
 * @classname: TestsController
 * @description:
 * @author: zbb
 * @create: 2022-02-15
 */
@RestController
public class TestsController {

//    @Value("${server.port}")
//    private String ports;

    @RequestMapping("/")
    public String index(){
        return "This is a index";
    }

//    @RequestMapping("/prot")
//    public String port(){
//        return "This server port is: "+ ports;
//    }




}
