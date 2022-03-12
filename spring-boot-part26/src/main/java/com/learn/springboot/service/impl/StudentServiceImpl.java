package com.learn.springboot.service.impl;

import com.learn.springboot.entity.Student;
import com.learn.springboot.mapper.StudentMapper;
import com.learn.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Override
    public int insertByObject(Student student){
        return  studentMapper.insertByObject(student);
    }
    @CachePut(value = "student",key = "#student.id")
    @Override
    public Student updateStudent(Student student){
        studentMapper.updateStudent(student);
        return  student;
    }

    @Cacheable(value = "student",key = "#id",condition = "#id>11")
    @Override
    public Student findById(Long id) {
        System.out.println("findById数据库..." + id);
        return studentMapper.findById(id);
    }

    @CacheEvict(value = "student",key = "#id",allEntries = true,beforeInvocation = true)
    public void deleteStudent(@Param("id") Long id){
        System.out.println("deleteStudent数据库..." + id);
         studentMapper.deleteStudent(id);
    }
}
