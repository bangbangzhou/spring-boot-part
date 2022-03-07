package com.learn.springboot.controller;



import com.learn.springboot.entity.teacher.Teacher;
import com.learn.springboot.service.teacher.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/teacher")
@RestController
@AllArgsConstructor
public class TeacherController {

    /**
     * studentService注入StudentController
     */
    private TeacherService teacherService;

    @PostMapping("insert")
    public int insertByObject(@RequestBody Teacher teacher){
        return  teacherService.insertByObject(teacher);
    }

    @PostMapping("update")
    public Teacher updateStudent(@RequestBody Teacher teacher) {
        return   teacherService.updateTeacher(teacher);
    }

    @GetMapping("/select/{id}")
    public Teacher findByName(@PathVariable("id") Long id) {
        return teacherService.findById(id);
    }
}
