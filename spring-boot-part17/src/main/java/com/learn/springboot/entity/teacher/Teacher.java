package com.learn.springboot.entity.teacher;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name="teacher")
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
