package com.learn.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 性别默认男
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 注册手机号
     */
    private String mobile;

    /**
     * 注册邮箱
     */
    private String email;

    private Date createDate;

    private Date updateDate;

    /**
     * 帐户是否可用(1 可用，0 删除用户)
     */
    private Integer isEnabled;

    private static final long serialVersionUID = 1L;
}
