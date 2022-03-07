package com.learn.springboot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Value("${file.uploadAccessPath}")
    private String uploadAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadAccessPath)
                .addResourceLocations("file:"+uploadFolder);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大10MB
        factory.setMaxFileSize(DataSize.ofMegabytes(10L));
        /// 设置总上传数据总大小10GB
        factory.setMaxRequestSize(DataSize.ofGigabytes(10L));
        return factory.createMultipartConfig();
    }
}
