package com.learn.springboot.service.teacher.impl;


import com.learn.springboot.entity.teacher.Teacher;
import com.learn.springboot.entity.teacher.TeacherMapper;
import com.learn.springboot.service.teacher.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherMapper teacherMapper;

    @Override
    public int insertByObject(Teacher teacher){
        return  teacherMapper.insertByObject(teacher);
    }
    @Override
    public Teacher updateTeacher(Teacher teacher){
        teacherMapper.updateTeacher(teacher);
        return  teacher;
    }

    @Override
    public Teacher findById(Long id) {
        return teacherMapper.findById(id);
    }
}
