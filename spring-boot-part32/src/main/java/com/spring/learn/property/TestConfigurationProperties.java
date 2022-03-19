package com.spring.learn.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
public class TestConfigurationProperties {

    private String  epochStr;

    private String timeBits;

    private String workerBits;

    private String seqBits;
}
