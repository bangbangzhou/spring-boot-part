package com.learn.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * student
 * @author 
 */
@Data
@ApiModel(value = "学生实体类",description = "学生信息用作增删改查")
@JsonPropertyOrder(value={"name","mobile","sex"})
public class Student implements Serializable{

    @ApiModelProperty(value = "学生ID", name = "id", required = false, example = "0")
    @JsonIgnore
    private Long id;
    @ApiModelProperty(value = "学生电话", name = "mobile", required = true,example = "133333")
    private String mobile;
    @ApiModelProperty(value = "学生性别", name = "性别", required = true,example = "男")
    @JsonProperty("性别")
    private String sex;
    @ApiModelProperty(value = "学生姓名", name = "name", required = true,example = "张三")
    private String name;
    @ApiModelProperty(value = "学生年龄", name = "age", required = true,example = "20")
    private int age;
    @ApiModelProperty(value = "邮箱", name = "email", required = true,example = "133@qq.com")
    @JsonProperty("邮箱")
    private String email;
    @ApiModelProperty(value = "是否可用1可用，0不不用", name = "isEnabled", required = false,example = "1")
    private int isEnabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private Date updateDate;

}
