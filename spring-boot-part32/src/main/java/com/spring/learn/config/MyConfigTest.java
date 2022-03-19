package com.spring.learn.config;

import com.spring.learn.property.TestConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigTest {

    public MyConfigTest(){
        System.out.println("my config test");
    }

    @Bean
    public String configtest(){
        return "hello config bean";
    }

    @Bean("testconfigurationproperties2")
    public TestConfigurationProperties testConfigurationProperties2(){
        TestConfigurationProperties properties = new TestConfigurationProperties();
        properties.setEpochStr("test2");
        properties.setSeqBits("test2");
        properties.setTimeBits("test2");
        properties.setWorkerBits("test2");
        return properties;
    }


    @Bean("testconfigurationproperties3")
    public TestConfigurationProperties testConfigurationProperties3(){
        TestConfigurationProperties properties = new TestConfigurationProperties();
        properties.setEpochStr("test3");
        properties.setSeqBits("test3");
        properties.setTimeBits("test3");
        properties.setWorkerBits("test3");
        return properties;
    }
}
