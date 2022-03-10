package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {



    @Autowired
    private StudentService studentService;

    @GetMapping("/selectall")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
