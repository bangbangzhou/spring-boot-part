package com.learn.springboot.mapper;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    Student findById(@Param("id") Long id);
    void updateStudent(Student student);
    void deleteStudent(@Param("id") Long id);
    int insertByObject(Student student);
}
