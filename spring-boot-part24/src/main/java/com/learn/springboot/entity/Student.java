package com.learn.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * student
 * @author 
 */
@Data
@JsonPropertyOrder(value={"name","mobile","sex"})
public class Student implements Serializable{

    @JsonIgnore
    private Long id;
    private String mobile;
    @JsonProperty("性别")
    private String sex;
    private String name;

    private int age;
    @JsonProperty("邮箱")
    private String email;

    private int isEnabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private Date updateDate;

}
