package com.learn.springboot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-part8
 * @package: com.learn.springboot.properties
 * @classname: StudentProperties
 * @description:
 * @author: zbb
 * @create: 2022-02-22
 */
@Data

@Component
@ConfigurationProperties("student")
public class StudentProperties {

    private String name;

    private String age;

    private String sex;

}
