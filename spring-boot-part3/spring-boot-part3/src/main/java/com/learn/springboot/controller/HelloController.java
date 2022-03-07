package com.learn.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-part3
 * @package: com.learn.springboot.controller
 * @classname: HelloController
 * @description:
 * @author: zbb
 * @create: 2022-02-16
 */
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/")
    public String index(){
        //由低到高 trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("trace级别的日志");
        logger.debug("debug级别的日志");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("info级别的日志");
        logger.warn("warn级别的日志");
        logger.error("error级别的日志");

        return  "logger info ";
    }
}
