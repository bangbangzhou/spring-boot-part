package com.learn.springboot.mapper;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student findById(@Param("id") Long id);
    List<Student> selectAll();
    void updateStudent(Student student);
    int insertByObject(Student student);
}
