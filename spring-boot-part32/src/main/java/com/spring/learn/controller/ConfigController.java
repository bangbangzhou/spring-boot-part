package com.spring.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private String configtest;

    @GetMapping("beanconfig")
    public String beanconfig(){
        return configtest;
    }
}
