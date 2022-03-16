package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContrController {

    @GetMapping(value = "test")
    public String test(String msg, Model model){
        //在对test页面渲染通过ModeMap，向页面添加了一个msg，
        // 参数，它的值为参数msg的内容
        model.addAttribute("msg",msg);
        return "test"; //值test表示的是模板页面对应的名称
    }

    @GetMapping(value = "test2")
    @ResponseBody
    public String test2(String msg, Model model){
        //在对test页面渲染通过ModeMap，向页面添加了一个msg，
        // 参数，它的值为参数msg的内容
        model.addAttribute("msg",msg);
        return "test"; //值test表示的是模板页面对应的名称
    }



}
