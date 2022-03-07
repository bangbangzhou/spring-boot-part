package com.learn.springboot.service.teacher;

import com.learn.springboot.entity.teacher.Teacher;

public interface TeacherService {

    Teacher updateTeacher(Teacher teacher);
    int insertByObject(Teacher teacher);
    Teacher findById(Long id);
}
