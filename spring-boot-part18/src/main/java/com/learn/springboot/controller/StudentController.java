package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("create")
    public int create(String name, String sex, Integer age, String email, String mobile) {
        int insert = studentService.insert(name, sex, age, email, mobile);
        return  insert;
    }
    @PostMapping("insert")
    public int insertByObject(@RequestBody Student student){
        return  studentService.insertByObject(student);
    }

    @PostMapping("update")
    public Student updateStudent(@RequestBody Student student) {
      return   studentService.updateStudent(student);
    }

    @GetMapping("/select/{id}")
    public Student findByName(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
}
