package com.learn.springboot.service.student;

import com.learn.springboot.entity.student.Student;

public interface StudentService {
    Student updateStudent(Student student);
    int insertByObject(Student student);
    Student findById(Long id);

}
