package com.learn.springboot.controller;

import com.learn.springboot.mode.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testPage(HttpServletRequest request, HttpSession session, Model model){
        Date date = new Date();
        Student stu1 = new Student("张三", 20, "<span style='color:red'>男</span>",80,90,"1.png",date);
        request.setAttribute("stu1",stu1);
        Student stu2 = new Student("李四", 21, "<span style='color:red'>男</span>",87,93,"1.png",date);
        session.setAttribute("stu2",stu2);
        Student stu3 = new Student("小芳", 19, "<span style='color:green'>女</span>",87,99,"1.png",date);
        ServletContext application = request.getServletContext();
        application.setAttribute("stu3", stu3);
        ArrayList<Student> stus = new ArrayList<>();

        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);

        model.addAttribute("stus", stus);
        return "test";
    }
}
