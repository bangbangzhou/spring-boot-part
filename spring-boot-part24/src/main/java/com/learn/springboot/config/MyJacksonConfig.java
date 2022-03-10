package com.learn.springboot.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

//@Configuration
//public class MyJacksonConfig {
//
//
//    @Bean
//    @Primary
//    @ConditionalOnMissingBean
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder){
//        ObjectMapper mapper = builder.createXmlMapper(false).build();
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return  mapper;
//    }
//}
