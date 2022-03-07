package com.learn.springboot.controller;



import com.learn.springboot.api.Result;
import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result insertByObject(@RequestBody Student student){
        Integer byObject = studentService.insertByObject(student);
        return  Result.success(byObject.toString());
    }

    @PostMapping("update")
    public Result<Student> updateStudent(@RequestBody Student student) {
        return   Result.data(studentService.updateStudent(student));
    }

    @GetMapping("/select/{id}")
    public Result<Student> findByName(@PathVariable("id") Long id) {
        Student byId = studentService.findById(id);

        return Result.data(studentService.findById(id));
    }

    @GetMapping("/selectAll")
    public Result<List<Student>> selectAll() {
        List<Student> students = studentService.selectAll();

        return  Result.data(students);
    }
}
