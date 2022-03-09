package com.learn.springboot.controller;



import com.learn.springboot.api.ResultCode;
import com.learn.springboot.exception.BaseException;
import com.learn.springboot.exception.ValidateCodeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo11
 * @package: com.springboot.learn.controller
 * @classname: TestController
 * @description:
 * @author: zbb
 * @create: 2022-03-07
 */
@RequestMapping("test")
@RestController
public class TestController {


    @GetMapping("/base/{name}")
    public void BaseException(@PathVariable("name") String name) {
        System.out.println("Hello: BaseException "+ name);
        throw  new BaseException(ResultCode.FAILURE.getCode(),ResultCode.FAILURE.getMsg());
    }

    @GetMapping("/valid/{name}")
    public void ValidateCodeException(@PathVariable("name") String name) {
        System.out.println("Hello:  ValidateCodeException "+ name);
        throw  new ValidateCodeException(ResultCode.GLOBAL_PARAM_ERROR.getCode(),ResultCode.GLOBAL_PARAM_ERROR.getMsg());
    }
}
