package com.learn.springboot.service.impl;

import com.learn.springboot.entity.Student;
import com.learn.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private JdbcTemplate primaryJdbcTemplate;

    private JdbcTemplate secondJdbcTemplate;


    @Override
    public List<Student> getAllSutdents() {

        List<Student> students = primaryJdbcTemplate.query("select name,sex,age,mobile,email from student where is_enabled=1", (resultSet, i) -> {
            Student stu = new Student();
            stu.setName(resultSet.getString("name"));
            stu.setSex(resultSet.getString("sex"));
            stu.setAge(resultSet.getInt("age"));
            stu.setMobile(resultSet.getString("mobile"));
            stu.setEmail(resultSet.getString("email"));
            return stu;
        });
        return students;
    }

    @Override
    public int Create(String name,String sex, int age,String mobile, String email) {
        int update = primaryJdbcTemplate.update("INSERT INTO student(name ,sex,age,mobile,email) VALUES(?,?,?,?,?)",
                name, sex, age, mobile, email);
        return update;
    }

    @Override
    public int deleteByName(String name) {
        return primaryJdbcTemplate.update("update student set is_enabled=0 where name = ?", name);
    }
}
