package com.learn.springboot.service;


import com.learn.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    Student updateStudent(Student student);
    int insertByObject(Student student);
    Student findById(Long id);

    List<Student> selectAll();

}
