package com.learn.springboot.service.student.impl;

import com.learn.springboot.entity.student.Student;
import com.learn.springboot.entity.student.StudentMapper;
import com.learn.springboot.service.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
