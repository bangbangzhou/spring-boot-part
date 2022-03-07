package com.learn.springboot.service.impl;

import com.learn.springboot.entity.Student;
import com.learn.springboot.mapper.StudentMapper;
import com.learn.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Override
    public int insert(String name, String sex, Integer age, String email, String mobile) {
        int insert = studentMapper.insert(name, sex, age, email, mobile);
        return  insert;
    }

    @Override
    public int insertByObject(Student student){
        return  studentMapper.insertByObject(student);
    }
    @Override
    public  Student  updateStudent(Student student){
        studentMapper.updateStudent(student);
        return  student;
    }

    @Override
    public Student findById( Long id) {
        return studentMapper.findById(id);
    }
}
