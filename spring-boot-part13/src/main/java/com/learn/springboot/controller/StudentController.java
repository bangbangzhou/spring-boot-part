package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("create")
    public int Create(String name, String sex, int age, String mobile, String email) {
        int create = studentService.Create(name, sex, age, mobile, email);
        return  create;
    }
    @GetMapping("getallstudents")
    public List<Student> getAllSutdents(){

        List<Student> allSutdents = studentService.getAllSutdents();
        return allSutdents;
    }
    @GetMapping("deleteByName")
    public int deleteByName(String name) {
        return studentService.deleteByName(name);
    }
}
