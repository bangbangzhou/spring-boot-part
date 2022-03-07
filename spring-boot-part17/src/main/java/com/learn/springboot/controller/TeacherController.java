package com.learn.springboot.controller;


import com.learn.springboot.entity.PageNumber;
import com.learn.springboot.entity.teacher.TeacherService;
import com.learn.springboot.entity.teacher.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @GetMapping("allteachers")
    public Slice<Teacher> getAllTeachers(PageNumber pageNumber){
        if(pageNumber.getNumber()==0){
            pageNumber =new PageNumber();
            pageNumber.setNumber(0);
            pageNumber.setSize(10);
        }
        //分页查询
        Slice<Teacher> createDate = teacherService.getAllTeachers(PageRequest.of(pageNumber.getNumber(), pageNumber.getSize(), Sort.by("createDate")));
        return createDate;
    }

    /**
     * 保存数据
     * @param teacher
     * @return
     */
    @PostMapping("create")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        //保存一个对象到数据库，insert
        teacherService.save(teacher);
        return  teacher;
    }

    @GetMapping("/{id}")
    public Teacher getTeacherInfo(@PathVariable("id") Long id) {
        Optional<Teacher> optional = teacherService.findById(id);
        return optional.orElseGet(Teacher::new);
    }


    @GetMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable("id") Long id) {

        //根据id删除1条数据库记录
        teacherService.deleteById(id);
    }

    @PostMapping("update")
    public @ResponseBody
    Teacher updatTeacher(@RequestBody Teacher teacher) {
        Optional<Teacher> optional = teacherService.findById(teacher.getId());
        Teacher tea = optional.orElseGet(Teacher::new);
        tea.setEmail(teacher.getEmail());
        tea.setCourse(teacher.getCourse());
        tea.setMobile(teacher.getEmail());
        tea.setAge(teacher.getAge());
        tea.setSex(teacher.getSex());
        tea.setName(teacher.getName());
        tea.setUpdateDate(new Date());
        //保存一个对象到数据库，insert
        Teacher save = teacherService.save(tea);
        return  save;
    }



    @GetMapping("getall")
    public Page<Teacher> getAll(PageNumber pageNumber) {
        if(pageNumber.getNumber()==0){
            pageNumber =new PageNumber();
            pageNumber.setNumber(0);
            pageNumber.setSize(10);
        }
        Page<Teacher> teachers =teacherService.findAll(PageRequest.of(pageNumber.getNumber(),pageNumber.getSize()));
        //查询teacher表的所有数据
        return teachers;
    }

    @GetMapping("getAllTeacher")
    public Page<Teacher> getAllTeacher(PageNumber pageNumber) {
        if(pageNumber.getNumber()==0){
            pageNumber =new PageNumber();
            pageNumber.setNumber(0);
            pageNumber.setSize(10);

        }
        Page<Teacher> teachers =teacherService.findAll(PageRequest.of(pageNumber.getNumber(),pageNumber.getSize()));
        //查询teacher表的所有数据
        return teachers;
    }
}