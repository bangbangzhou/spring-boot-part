package com.learn.springboot.service;

import com.learn.springboot.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    Student getStudent(Long id);

    List<Student> getAll();

}
