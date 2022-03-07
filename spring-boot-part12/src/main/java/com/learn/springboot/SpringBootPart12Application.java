package com.learn.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPart12Application {
    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(SpringBootPart12Application.class);
//        application.setBanner(new MyBannerConfig());
//        application.run(args);
       SpringApplication.run(SpringBootPart12Application.class, args);
    }
}
