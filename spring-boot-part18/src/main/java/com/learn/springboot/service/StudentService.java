package com.learn.springboot.service;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentService {

    int insert( String name,
                String sex,
                Integer age,
               String email,
                String mobile
    );

    Student  updateStudent(Student student);

    int insertByObject(Student student);

    Student findById( Long id);


}
