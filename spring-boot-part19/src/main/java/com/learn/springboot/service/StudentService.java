package com.learn.springboot.service;

import com.learn.springboot.entity.Student;

public interface StudentService {
    Student updateStudent(Student student);
    int insertByObject(Student student);
    Student findById(Long id);

}
