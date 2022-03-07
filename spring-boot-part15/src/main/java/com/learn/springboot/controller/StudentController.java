package com.learn.springboot.controller;

import com.learn.springboot.entity.PageNumber;
import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("getallstudents")
    public Slice<Student> getAllSutdents(PageNumber pageNumber){
        if(pageNumber.getNumber()==0){
            pageNumber =new PageNumber();
            pageNumber.setNumber(0);
            pageNumber.setSize(10);

        }
        //分页查询
        Slice<Student> createDate = studentService.getAllSutdents(PageRequest.of(pageNumber.getNumber(), pageNumber.getSize(), Sort.by("createDate")));
        return createDate;
    }

    /**
     * 保存数据
     * @param student
     * @return
     */
    @PostMapping("create")
    public Student saveStudent(@RequestBody Student student) {
        //保存一个对象到数据库，insert
        studentService.save(student);
        return  student;
    }

    @GetMapping("/{id}")
    public Student getSutdentInfo(@PathVariable("id") Long id) {
        Optional<Student> optional = studentService.findById(id);
        return optional.orElseGet(Student::new);
    }


    @GetMapping("/delete/{id}")
    public void deleteSutdent(@PathVariable("id") Long id) {

        //根据id删除1条数据库记录
        studentService.deleteById(id);
    }

    @PostMapping("update")
    public @ResponseBody Student updatSutdent(@RequestBody Student student) {
        Optional<Student> optional = studentService.findById(student.getId());
        Student stu = optional.orElseGet(Student::new);
        stu.setEmail(student.getEmail());
        stu.setMobile(student.getEmail());
        stu.setAge(student.getAge());
        stu.setSex(student.getSex());
        stu.setName(student.getName());
        stu.setUpdateDate(new Date());
        //保存一个对象到数据库，insert
        Student save = studentService.save(student);
        return  save;
    }



    @GetMapping("getall")
    public  Page<Student> getAll( PageNumber pageNumber) {
        if(pageNumber.getNumber()==0){
            pageNumber =new PageNumber();
            pageNumber.setNumber(0);
            pageNumber.setSize(10);

        }

        Page<Student> studentList =studentService.findAll(PageRequest.of(pageNumber.getNumber(),pageNumber.getSize()));
        //查询article表的所有数据
        return studentList;
    }
}


//@Slf4j
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping("getallstudents")
//    public List<Student> getAllSutdents(PageNumber pageNumber){
//
//
//        studentService.getAllSutdents(PageRequest.of(pageNumber.getNumber(),pageNumber.getSize(), Sort.by("createDate")));
//
//        List<Student> allSutdents = studentService.getAllSutdents();
//        return allSutdents;
//    }
//
//    /**
//     * 保存数据
//     * @param student
//     * @return
//     */
//    @PostMapping("create")
//    public Student saveStudent(@RequestBody Student student) {
//        //保存一个对象到数据库，insert
//        studentService.saveAndFlush(student);
//        return  student;
//    }
//
//    @GetMapping("/{id}")
//    public Student getSutdentInfo(@PathVariable("id") Long id) {
//        Optional<Student> optional = studentService.findById(id);
//        return optional.orElseGet(Student::new);
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public void deleteSutdent(@PathVariable("id") Long id) {
//
//        //根据id删除1条数据库记录
//        studentService.deleteById(id);
//    }
//
//    @PostMapping("update")
//    public @ResponseBody Student updatSutdent(@RequestBody Student student) {
//        Optional<Student> optional = studentService.findById(student.getId());
//        Student stu = optional.orElseGet(Student::new);
//        stu.setEmail(student.getEmail());
//        stu.setMobile(student.getEmail());
//        stu.setAge(student.getAge());
//        stu.setSex(student.getSex());
//        stu.setName(student.getName());
//        stu.setUpdateDate(new Date());
//        //保存一个对象到数据库，insert
//        Student save = studentService.save(student);
//        return  save;
//    }
//
//
//
//    @GetMapping("getall")
//    public List<Student> getAll() {
//        List<Student> studentList = studentService.findAll();
//        //查询article表的所有数据
//        return studentList;
//    }
//}
