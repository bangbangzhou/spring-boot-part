package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "welcome my test page");
        return "test";
    }
}
