package com.learn.springboot.service.impl;


import com.learn.springboot.entity.Student;
import com.learn.springboot.mapper.StudentMapper;
import com.learn.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Override
    public int insertByObject(Student student){
        return  studentMapper.insertByObject(student);
    }
    @Override
    public Student updateStudent(Student student){
        studentMapper.updateStudent(student);
        return  student;
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }
}
