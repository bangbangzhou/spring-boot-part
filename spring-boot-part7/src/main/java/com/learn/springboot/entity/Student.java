package com.learn.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String sqx;
    private int age;
    private String email;
    private String mobile;
}
