package com.learn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.learn.springboot.mapper")
@SpringBootApplication
public class SpringBootPart21Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPart21Application.class, args);
    }

}
