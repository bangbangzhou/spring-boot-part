package com.learn.springboot.entity.teacher;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher findById(@Param("id") Long id);
    void updateTeacher(Teacher student);
    int insertByObject(Teacher student);
}
