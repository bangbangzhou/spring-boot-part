package com.learn.springboot.mode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String sex;
    private int cgrade;
    private int egrade;
    private String img;
    private Date createtime;
}
