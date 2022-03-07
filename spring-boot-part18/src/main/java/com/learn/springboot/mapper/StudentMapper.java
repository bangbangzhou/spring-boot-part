package com.learn.springboot.mapper;

import com.learn.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {


    @Select("SELECT * FROM STUDENT WHERE ID = #{id}")
    Student  findById(@Param("id") Long id);


    @Update("UPDATE STUDENT SET NAME=#{name},SEX=#{sex},AGE=#{age},EMAIL=#{email},MOBILE=#{mobile} WHERE id=#{id}")
    void updateStudent(Student student);


    @Insert("INSERT INTO STUDENT(NAME, SEX,AGE,EMAIL,MOBILE) VALUES(#{name}, #{sex}, #{age}, #{email}, #{mobile})")
    int insert(@Param("name") String name,
               @Param("sex") String sex,
               @Param("age") Integer age,
               @Param("email") String email,
               @Param("mobile") String mobile
               );

    @Insert("INSERT INTO STUDENT(NAME, SEX,AGE,EMAIL,MOBILE) VALUES(#{name}, #{sex}, #{age}, #{email}, #{mobile})")
    int insertByObject(Student student);
}
