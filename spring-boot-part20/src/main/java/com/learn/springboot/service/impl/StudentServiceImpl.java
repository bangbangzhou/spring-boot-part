package com.learn.springboot.service.impl;

import com.learn.springboot.entity.Student;
import com.learn.springboot.mapper.StudentDaoMapper;
import com.learn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    /**
     * mapper注入
     */
    @Autowired
    private StudentDaoMapper studentDaoMapper;


    /**
     * 添加学生
     * @param student
     */
    @Override
    public void saveStudent(Student student) {
        //该方法由自动代码生成
        studentDaoMapper.insert(student);
    }

    /**
     * 根据ID删除学生
     * @param id
     */
    @Override
    public void deleteStudent(Long id) {
        //该方法由自动代码生成
        studentDaoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新学生
     * @param student
     */
    @Override
    public void updateStudent(Student student) {
        //该方法由自动代码生成
        studentDaoMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * 根据ID查询学生
     * @param id
     * @return
     */
    @Override
    public Student getStudent(Long id) {
        //该方法由自动代码生成
        return studentDaoMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有数据
     * @return
     */
    @Override
    public List<Student> getAll() {
        //该方法由自动代码生成
        return studentDaoMapper.selectByExample(null);
    }
}
