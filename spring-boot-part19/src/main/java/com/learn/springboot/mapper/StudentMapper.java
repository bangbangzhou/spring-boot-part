package com.learn.springboot.mapper;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {
    Student findById(@Param("id") Long id);
    void updateStudent(Student student);
    int insertByObject(Student student);
}
