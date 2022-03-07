package com.learn.springboot.entity.student;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student findById(@Param("id") Long id);
    void updateStudent(Student student);
    int insertByObject(Student student);
}
