package com.learn.springboot.service;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentService {
    Student updateStudent(Student student);
    int insertByObject(Student student);
    Student findById(Long id);
    void deleteStudent(@Param("id") Long id);

}
