package com.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("zhihu")
    public String test(){
        String forEntity = restTemplate.getForObject("https://zhuanlan.zhihu.com/api/columns/zhihuadmin", String.class);
        return forEntity;
    }
}
