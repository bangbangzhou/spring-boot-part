package com.learn.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class MyWebConfig implements WebMvcConfigurer {
//
//    /**
//     *  addResourceHandler 这个方法是配置资源请求路径
//     *  addResourceLocations 这个方法是配置自定义静态资源存储位置，里边用到了file:，
//     *  是因为资源放置位置不在classpath下边，是自定义的，也可以写为classpath:
//     */
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
//    }
//
//}
