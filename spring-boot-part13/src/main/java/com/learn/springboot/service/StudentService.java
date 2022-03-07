package com.learn.springboot.service;

import com.learn.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 获取所有学生信息
     * @return
     */
    List<Student> getAllSutdents();

    /**
     * 创建学生
     * @param name
     * @param age
     * @return
     */
    int Create(String name,String sex, int age,String mobile, String email);

    /**
     * 根据name删除学生信息
     * @param name
     * @return
     */
    int deleteByName(String name);
}
