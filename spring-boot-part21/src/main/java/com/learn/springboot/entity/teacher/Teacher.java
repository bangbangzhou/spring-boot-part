package com.learn.springboot.entity.teacher;

import lombok.Data;

import java.util.Date;


@Data
public class Teacher {

    private Long id;
    private String name;
    private String sex;
    private String course;
    private int age;
    private String email;
    private String mobile;
    private int isEnabled;
    private Date createDate;
    private Date updateDate;

}
