package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试Swagger",tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {
    /**
     *测试
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = false, paramType = "path",dataType = "String",
                    example = "张三",defaultValue="张三"),
    })
    @ApiOperation(value = "测试",tags = "测试",notes = "测试swagger")
    @GetMapping("/{name}")
    public String test(@PathVariable("name")String name) {
        return "Hello :" +name;
    }

    /**
     *测试student
     */
    @ApiOperation(value = "测试student",tags = "测试",notes = "测试student")
    @PostMapping("/student")
    public Student testStudent(@RequestBody Student student) {
        return  student;
    }
}
