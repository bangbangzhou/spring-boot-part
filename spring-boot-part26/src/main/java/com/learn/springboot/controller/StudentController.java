package com.learn.springboot.controller;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/student")
@RestController
public class StudentController {

    /**
     * studentService注入StudentController
     */
    @Autowired
    private StudentService studentService;

    @PostMapping("insert")
    public int insertByObject(@RequestBody Student student){
        return  studentService.insertByObject(student);
    }

    @PostMapping("update")
    public Student updateStudent(@RequestBody Student student) {
      return   studentService.updateStudent(student);
    }

    @GetMapping("/select/{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
         studentService.deleteStudent(id);
    }
}
