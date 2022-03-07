package com.learn.springboot.entity;

import javax.validation.constraints.Email;

public class Student {

    @Email(message = "邮箱格式不正确")
    private String email;

}
