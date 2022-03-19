package com.spring.learn.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "uid")
public class UidConfigurationProperties {
    private String  epochStr;

    private String timeBits;

    private String workerBits;

    private String seqBits;
}
