package com.spring.learn.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-part32
 * @package: com.spring.learn.controller
 * @classname: RequestController
 * @description: 请求类注解实例
 * @author: zbb
 * @create: 2022-03-18
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    @GetMapping("/variable/{id}/{name}")
    public String Test(@PathVariable("id")String id,@PathVariable("name")String name){
        return "id: "+id +" name: "+name;
    }

    @GetMapping("/param")
    public String param(@RequestParam(value = "id",required = false,defaultValue ="1")String id,
                        @RequestParam(value = "name",required = true)String name){
        return "id: "+id +" name: "+name;
    }

    @GetMapping(value="/header")
    public String header(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(value="Accept-Encoding")String accepts){
        return "User-Agent: "+userAgent+"  Accept-Encoding  "+accepts;
    }

    @GetMapping(value="/cookie")
    public String Cookie(
            @CookieValue(value="SESSIONID", defaultValue="") String SESSIONID){
        return "SESSIONID: "+SESSIONID;
    }


}
