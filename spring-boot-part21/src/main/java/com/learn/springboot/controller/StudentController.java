package com.learn.springboot.controller;


import com.learn.springboot.entity.student.Student;
import com.learn.springboot.service.student.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/student")
@RestController
@AllArgsConstructor
public class StudentController {

    /**
     * studentService注入StudentController
     */

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
    public Student findByName(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
}
