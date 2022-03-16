package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TestController {
    @GetMapping("/")
    public String index(Model model) {
        Student stu1 = new Student("张三","男", 20, "1155@qq.com", "13333835901");
        Student stu2 = new Student("李四", "男",21, "1154@qq.com", "13333835902");
        Student stu3 = new Student("王五", "男",22, "1153@qq.com", "13333835903");
        Student stu4 = new Student("小芳","男", 23, "1156@qq.com", "13333835904");
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);
        stus.add(stu4);
        model.addAttribute("stus", stus);
        return "index";
    }
}
