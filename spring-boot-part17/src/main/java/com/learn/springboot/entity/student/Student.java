package com.learn.springboot.entity.student;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name="student")
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
