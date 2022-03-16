package com.learn.springboot.controller;

import com.learn.springboot.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLTransactionRollbackException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("comments")
    public String test(){
        String forEntity = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments?author.name=typicode", String.class);
        return forEntity;
    }

    @GetMapping("/comments/entity")
    public TestEntity[] entity(){
        TestEntity[] forEntity = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments?author.name=typicode", TestEntity[].class);
        return forEntity;
    }


    @GetMapping("/comments_1/{type}")
    public TestEntity[] testentity_1(@PathVariable("type")String type){
        TestEntity[] forEntity = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments?author.name={type}", TestEntity[].class,type);
        return forEntity;
    }

    @GetMapping("/comments_2/{type}")
    public TestEntity[] testentity_2(@PathVariable("type")String type){
        TestEntity[] forEntity = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments?author.name={1}", TestEntity[].class,type);
        return forEntity;
    }

    @GetMapping("/comments_map/{type}")
    public TestEntity[] testentity_3(@PathVariable("type")String type){

        Map<String,Object> map = new HashMap<>();
        map.put("type",map);
        TestEntity[] forEntity = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments?author.name={type}", TestEntity[].class,map);
        return forEntity;
    }


    @GetMapping("/getForEntity/{type}")
    public TestEntity[] getForEntity(@PathVariable("type")String type){

        Map<String,Object> map = new HashMap<>();
        map.put("type",map);
        ResponseEntity<TestEntity[]> forEntity = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/comments?author.name={type}", TestEntity[].class,map);

        System.out.println("状态： " +forEntity.getStatusCode());
        System.out.println("状态码： " +forEntity.getStatusCodeValue());
        System.out.println("Headers： " +forEntity.getHeaders());


        return forEntity.getBody();
    }
}
