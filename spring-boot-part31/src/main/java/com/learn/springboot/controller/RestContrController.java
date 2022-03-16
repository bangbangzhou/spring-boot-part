package com.learn.springboot.controller;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Repository
@RestController
public class RestContrController {

    @GetMapping(value = "rest/test")
    public String test(String msg, Model model){
        //在对test页面渲染通过ModeMap，向页面添加了一个msg，
        // 参数，它的值为参数msg的内容
        model.addAttribute("msg",msg);
        return "test"; //值test表示的是模板页面对应的名称
    }



    @GetMapping(value = "rest/main")
    public ModelAndView main(String msg){
        ModelAndView andView = new ModelAndView();
        andView.addObject("msg",msg);
        andView.setViewName("main");
        return andView;
    }


}
