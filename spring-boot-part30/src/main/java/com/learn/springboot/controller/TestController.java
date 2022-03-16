package com.learn.springboot.controller;

import com.learn.springboot.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/testpost")
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("comments")
    public TestEntity test(){
        TestEntity entity = new TestEntity();
        entity.setId(501);
        entity.setPostId(101);
        entity.setBody("test demo");
        entity.setEmail("Davion@zz.net");
        entity.setName("zhouo bang");
        TestEntity forEntity = restTemplate.postForObject("http://jsonplaceholder.typicode.com/comments", entity,TestEntity.class);
        return forEntity;
    }

    @PostMapping("comments/form")
    public String testform(){
        // 请求地址
        String url = "http://jsonplaceholder.typicode.com/comments";
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //提交参数设置
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("postId", "102");
        map.add("id", "502");
        map.add("name", "li si");
        map.add("email", "qq.@qq.com");
        map.add("body", "my body");
        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        String result = restTemplate.postForObject(url, request, String.class);
        return result;
    }

    @PostMapping("comments_1/{type}")
    public TestEntity test_1(@PathVariable("type")String type){
        TestEntity entity = new TestEntity();
        entity.setId(501);
        entity.setPostId(101);
        entity.setBody("test demo");
        entity.setEmail("Davion@zz.net");
        entity.setName("zhouo bang");
        TestEntity forEntity = restTemplate.postForObject("http://jsonplaceholder.typicode.com/{1}", entity,TestEntity.class,type);
        return forEntity;
    }

    @PostMapping("comments_2/{type}")
    public TestEntity test_2(@PathVariable("type")String type){
        TestEntity entity = new TestEntity();
        entity.setId(501);
        entity.setPostId(101);
        entity.setBody("test demo");
        entity.setEmail("Davion@zz.net");
        entity.setName("zhouo bang");
        TestEntity forEntity = restTemplate.postForObject("http://jsonplaceholder.typicode.com/{type}", entity,TestEntity.class,type);
        return forEntity;
    }
    @PostMapping("comments_3/{type}")
    public TestEntity test_3(@PathVariable("type")String type){
        TestEntity entity = new TestEntity();
        entity.setId(501);
        entity.setPostId(101);
        entity.setBody("test demo");
        entity.setEmail("Davion@zz.net");
        entity.setName("zhouo bang");
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        TestEntity forEntity = restTemplate.postForObject("http://jsonplaceholder.typicode.com/{type}", entity,TestEntity.class,map);
        return forEntity;
    }


    @PostMapping("comments_4/{type}")
    public TestEntity test_4(@PathVariable("type")String type){

        TestEntity entity = new TestEntity();
        entity.setId(520);
        entity.setPostId(110);
        entity.setBody("comments_4 demo");
        entity.setEmail("comments_4@zz.net");
        entity.setName("zhouo comments_4");
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        ResponseEntity<TestEntity> forEntity = restTemplate.postForEntity("http://jsonplaceholder.typicode.com/{type}", entity,TestEntity.class,map);

        System.out.println("StatusCode: "+ forEntity.getStatusCode());
        System.out.println("StatusCodeValue: "+forEntity.getStatusCodeValue());
        System.out.println("Headers: "+ forEntity.getHeaders());

        return forEntity.getBody();
    }

    @PostMapping("comments_5/{type}")
    public URI test_5(@PathVariable("type")String type){

        TestEntity entity = new TestEntity();
        entity.setId(520);
        entity.setPostId(110);
        entity.setBody("comments_4 demo");
        entity.setEmail("comments_4@zz.net");
        entity.setName("zhouo comments_4");
        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        URI uri = restTemplate.postForLocation("http://jsonplaceholder.typicode.com/{type}",entity,map);
        return uri;
    }
}
