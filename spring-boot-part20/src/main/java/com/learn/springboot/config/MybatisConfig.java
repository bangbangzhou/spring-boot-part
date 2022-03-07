package com.learn.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.learn.springboot.mapper"})
public class MybatisConfig {
}
