package com.spring.learn.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-boot-part32
 * @package: com.spring.learn.property
 * @classname: testproperties
 * @description:
 * @author: zbb
 * @create: 2022-03-18
 */
@Data
@Configuration
@PropertySource("classpath:test.properties")
public class Testproperties {

    @Value("${test.epochStr}")
    private String  epochStr;
    @Value("${test.timeBits}")
    private String timeBits;
    @Value("${test.workerBits}")
    private String workerBits;
    @Value("${test.seqBits}")
    private String seqBits;
}
