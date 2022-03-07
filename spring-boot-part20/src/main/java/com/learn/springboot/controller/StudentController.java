package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("create")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("update")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @GetMapping("/select/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/selectall")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
