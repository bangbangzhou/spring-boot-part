package com.learn.springboot.entity.student;

import lombok.Data;

import java.util.Date;


@Data
public class Student {

    private Long id;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String mobile;
    private int isEnabled;
    private Date createDate;
    private Date updateDate;

}
