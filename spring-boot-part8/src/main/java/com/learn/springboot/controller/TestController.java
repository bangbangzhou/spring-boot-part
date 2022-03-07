package com.learn.springboot.controller;

import com.learn.springboot.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-part8
 * @package: com.learn.springboot.controller
 * @classname: TestController
 * @description:
 * @author: zbb
 * @create: 2022-02-22
 */
@RestController
public class TestController {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private String age;
    @Value("${student.sex}")
    private String sex;
    @GetMapping("/test")
    public String test(){
        return "name: " + name+ "  age: "+age+" sex: "+sex;
    }


    @Autowired
    private StudentProperties properties;

    @GetMapping("/test2")
    public String test2(){
        return "name: " + properties.getName()+ "  age: "+properties.getAge()+" sex: "+properties.getSex();
    }
}
